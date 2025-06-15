package kr.co.khedu.fitroutine.post.controller;

import jakarta.validation.Valid;
import kr.co.khedu.fitroutine.post.model.dto.*;
import kr.co.khedu.fitroutine.post.service.PostReplyService;
import kr.co.khedu.fitroutine.security.model.dto.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class PostReplyController {
    private final PostReplyService postReplyService;

    public PostReplyController(PostReplyService postReplyService) {
        this.postReplyService = postReplyService;
    }

    @GetMapping("/posts/{postId}/replies")
    public ResponseEntity<List<? extends ReplyResponse>> getReplies(@PathVariable long postId) {
        return ResponseEntity.ok(postReplyService.getReplies(postId));
    }

    @GetMapping("/replies/{replyId}")
    public ResponseEntity<ReplyResponse> getReply(@PathVariable long replyId) {
        return ResponseEntity.ok(postReplyService.getReply(replyId));
    }

    @PostMapping("/posts/{postId}/replies")
    public ResponseEntity<ReplyResponse> createReply(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable long postId,
            @RequestBody @Valid ReplyCreateRequest createRequest
    ) {
        return ResponseEntity.ok(
                postReplyService.createReply(
                        postId,
                        userDetails.getMemberId(),
                        createRequest
                )
        );
    }

    @PreAuthorize("@postReplyService.isReplyOwner(#replyId, principal)")
    @DeleteMapping("/replies/{replyId}")
    public ResponseEntity<Void> deleteReply(@PathVariable long replyId) {
        postReplyService.deleteReply(replyId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/replies/{replyId}/likes")
    public ResponseEntity<ReplyLikesResponse> getReplyLikes(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable long replyId
    ) {
        return ResponseEntity.ok(postReplyService.getReplyLikes(userDetails.getMemberId(), replyId));
    }

    @PostMapping("/replies/{replyId}/likes")
    public ResponseEntity<Void> likeReply(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable long replyId
    ) {
        postReplyService.likeReply(userDetails.getMemberId(), replyId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/replies/{replyId}/likes")
    public ResponseEntity<Void> unlikeReply(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable long replyId
    ) {
        postReplyService.unlikeReply(userDetails.getMemberId(), replyId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/replies/{replyId}/details")
    public ResponseEntity<ReplyDetail> getReplyDetails(@PathVariable long replyId) {
        return ResponseEntity.ok(postReplyService.getReplyDetails(replyId));
    }

    @GetMapping("/replies/{replyId}/permissions")
    public ResponseEntity<Boolean> checkPermissionReply (
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable long replyId
    ) {
        return ResponseEntity.ok(postReplyService.checkPermissionReply(userDetails.getMemberId(), replyId));
    }

    @PatchMapping("/replies/{replyId}")
    public ResponseEntity<ReplyResponse> updateReply(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable long replyId,
            @RequestBody ReplyUpdateRequest replyUpdateRequest
    ) {
        return ResponseEntity.ok(postReplyService.updateReply(userDetails.getMemberId(), replyId, replyUpdateRequest.getContent()));
    }
}
