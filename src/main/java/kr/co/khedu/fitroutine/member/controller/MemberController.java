package kr.co.khedu.fitroutine.member.controller;

import kr.co.khedu.fitroutine.member.model.dto.BlogLikeList;
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
    public ResponseEntity<?> getMemberProfile() {
        // 추후에 토큰에서 회원을 얻도록 변경해야 합니다.
        long memberId = 1;

        return ResponseEntity.ok(memberService.getMemberProfile(memberId));
    }

    @GetMapping("/likeList")
    public ResponseEntity<?> getLikeList() {
        // 추후에 토큰에서 회원을 얻도록 변경해야 합니다.
        long memberId = 1;

        return ResponseEntity.ok(memberService.getLikeList(memberId));
    }

    @DeleteMapping("/likeList/delete")
    public ResponseEntity<?> deleteLikeList(@RequestParam long memberId) {
        long loginedId = 1;
        boolean result = memberService.deleteLike(memberId, loginedId);
        if (!result) {
            return ResponseEntity.status(400).body("failure");
        }
        return ResponseEntity.ok("success");
    }
}
