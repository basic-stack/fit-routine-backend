package kr.co.khedu.fitroutine.post.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import kr.co.khedu.fitroutine.post.model.dto.*;
import kr.co.khedu.fitroutine.post.service.PostService;
import kr.co.khedu.fitroutine.security.model.dto.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Validated
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<? extends PostResponse>> getPosts(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "12") @Min(1) @Max(12) int size,
            @RequestParam(defaultValue = "date") PostSort sort,
            @RequestParam(defaultValue = "desc") PostSortOrder order
    ) {
        return ResponseEntity.ok(postService.getPosts(null, page, size, sort, order));
    }

    @GetMapping("/blogs/{blogId}/posts")
    public ResponseEntity<List<? extends PostResponse>> getPosts(
            @PathVariable long blogId,
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "12") @Min(1) @Max(12) int size,
            @RequestParam(defaultValue = "date") PostSort sort,
            @RequestParam(defaultValue = "desc") PostSortOrder order
    ) {
        return ResponseEntity.ok(postService.getPosts(blogId, page, size, sort, order));
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostResponse> getPost(@PathVariable long postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @PreAuthorize("@blogService.isBlogOwner(#blogId, principal)")
    @PostMapping("/blogs/{blogId}/posts")
    public ResponseEntity<PostResponse> createPost(
            @PathVariable long blogId,
            @RequestBody @Valid PostCreateRequest createRequest
    ) {
        PostResponse postResponse = postService.createPost(
                blogId,
                createRequest
        );
        return ResponseEntity
                .created(URI.create("/posts/" + postResponse.getPostId()))
                .body(postResponse);
    }

    @PreAuthorize("@postService.isPostOwner(#postId, principal)")
    @PatchMapping("/posts/{postId}")
    public ResponseEntity<PostResponse> updatePost(
            @PathVariable long postId,
            @RequestBody @Valid PostUpdateRequest updateRequest
    ) {
        return ResponseEntity.ok(
                postService.updatePost(
                        postId,
                        updateRequest
                )
        );
    }

    @PreAuthorize("@postService.isPostOwner(#postId, principal)")
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/posts/{postId}/likes")
    public ResponseEntity<PostLikesResponse> getPostLikes(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable long postId
    ) {
        return ResponseEntity.ok(postService.getPostLikes(userDetails.getMemberId(), postId));
    }

    @PostMapping("/posts/{postId}/likes")
    public ResponseEntity<Void> likePost(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable long postId
    ) {
        postService.likePost(userDetails.getMemberId(), postId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/posts/{postId}/likes")
    public ResponseEntity<Void> unlikePost(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable long postId
    ) {
        postService.unlikePost(userDetails.getMemberId(), postId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/posts/{postId}/permissions")
    public ResponseEntity<Boolean> checkPermissionPost(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable long postId
    ) {
        return ResponseEntity.ok(postService.checkPermissionPost(userDetails.getMemberId(), postId));
    }
}
