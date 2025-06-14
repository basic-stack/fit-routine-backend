package kr.co.khedu.fitroutine.member.controller;

import jakarta.validation.Valid;
import kr.co.khedu.fitroutine.member.model.dto.*;
import kr.co.khedu.fitroutine.member.service.MemberService;
import kr.co.khedu.fitroutine.security.model.dto.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@Validated
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/me")
    public ResponseEntity<MemberResponse> getMember(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        return ResponseEntity.ok(memberService.getMember(userDetails.getMemberId()));
    }

    @GetMapping("/me/detail")
    public ResponseEntity<MemberDetailResponse> getMemberDetail(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        return ResponseEntity.ok(memberService.getMemberDetail(userDetails.getMemberId()));
    }

    @PostMapping
    public ResponseEntity<MemberCreateResponse> createMember(
            @RequestBody @Valid MemberCreateRequest createRequest
    ) {
        return ResponseEntity.ok(memberService.createMember(createRequest));
    }

    @PatchMapping("/me")
    public ResponseEntity<Void> updateMember(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestBody @Valid MemberUpdateRequest updateRequest
    ) {
        memberService.updateMember(userDetails.getMemberId(), updateRequest);
        return ResponseEntity.noContent().build();
    }
}
