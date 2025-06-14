package kr.co.khedu.fitroutine.member.controller;

import kr.co.khedu.fitroutine.member.model.dto.MemberUpdateRequest;
import kr.co.khedu.fitroutine.member.model.dto.MemberResponse;
import kr.co.khedu.fitroutine.member.service.MemberService;
import kr.co.khedu.fitroutine.security.model.dto.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public final class MemberController {
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

    @PatchMapping("/me")
    public ResponseEntity<MemberResponse> updateMember(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestBody MemberUpdateRequest updateRequest
    ) {
        return ResponseEntity.ok(memberService.updateMember(userDetails.getMemberId(), updateRequest));
    }
}
