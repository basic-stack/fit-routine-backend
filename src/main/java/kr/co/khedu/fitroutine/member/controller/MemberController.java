package kr.co.khedu.fitroutine.member.controller;

import kr.co.khedu.fitroutine.member.model.dto.BlogLikeList;
import kr.co.khedu.fitroutine.member.model.dto.MemberEditInfo;
import kr.co.khedu.fitroutine.member.model.dto.MemberProfile;
import kr.co.khedu.fitroutine.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public final class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/me")
    public ResponseEntity<MemberProfile> getMemberProfile() {
        // 추후에 토큰에서 회원을 얻도록 변경해야 합니다.
        long memberId = 1;

        return ResponseEntity.ok(memberService.getMemberProfile(memberId));
    }

    @PutMapping("/me")
    public ResponseEntity<String> editMemberProfile(@RequestBody MemberEditInfo memberEditInfo) {
        // 추후에 토큰에서 회원을 얻도록 변경해야 합니다.
        long memberId = 1;
        memberEditInfo.setMemberId(memberId);

        return memberService.editMemberProfile(memberEditInfo) ?
                ResponseEntity.ok("success") :
                ResponseEntity.status(500).body("failure");
    }

    @GetMapping("/me/likes")
    public ResponseEntity<List<? extends BlogLikeList>> getLikes() {
        // 추후에 토큰에서 회원을 얻도록 변경해야 합니다.
        long memberId = 1;

        return ResponseEntity.ok(memberService.getLikeList(memberId));
    }
}
