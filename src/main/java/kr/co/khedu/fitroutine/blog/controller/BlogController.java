package kr.co.khedu.fitroutine.blog.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import kr.co.khedu.fitroutine.blog.model.dto.*;
import kr.co.khedu.fitroutine.blog.service.BlogService;
import kr.co.khedu.fitroutine.security.model.dto.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@Validated
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/me")
    public ResponseEntity<Long> getBlogId(
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        return ResponseEntity.ok(blogService.getBlogId(userDetails.getMemberId()));
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<BlogResponse> getBlog(@PathVariable long blogId) {
        return ResponseEntity.ok(blogService.getBlog(blogId));
    }

    @PreAuthorize("@blogService.isBlogOwner(#blogId, principal)")
    @PatchMapping("/{blogId}")
    public ResponseEntity<BlogResponse> updateBlog(
            @PathVariable long blogId,
            @RequestBody @Valid BlogUpdateRequest blogUpdateRequest
    ) {
        return ResponseEntity.ok(
                blogService.updateBlog(
                        blogId,
                        blogUpdateRequest
                )
        );
    }

    @GetMapping("/{blogId}/followers")
    public ResponseEntity<List<? extends FollowResponse>> getFollowers(
            @PathVariable long blogId,
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "12") @Min(1) @Max(12) int size
    ) {
        return ResponseEntity.ok(blogService.getFollowers(blogId, page, size));
    }

    @GetMapping("/{blogId}/followers/count")
    public ResponseEntity<FollowCountResponse> getFollowersCount(@PathVariable long blogId) {
        return ResponseEntity.ok(blogService.getFollowersCount(blogId));
    }

    @GetMapping("/{blogId}/followings")
    public ResponseEntity<List<? extends FollowResponse>> getFollowings(
            @PathVariable long blogId,
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "12") @Min(1) @Max(12) int size
    ) {
        return ResponseEntity.ok(blogService.getFollowings(blogId, page, size));
    }

    @GetMapping("/{blogId}/followings/count")
    public ResponseEntity<FollowCountResponse> getFollowingsCount(@PathVariable long blogId) {
        return ResponseEntity.ok(blogService.getFollowingsCount(blogId));
    }

    @GetMapping("/{blogId}/follow")
    public ResponseEntity<FollowStatusResponse> checkFollow(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable long blogId
    ) {
        return ResponseEntity.ok(
                blogService.checkFollow(
                        blogService.getBlogId(userDetails.getMemberId()),
                        blogId
                )
        );
    }

    @PostMapping("/{blogId}/follow")
    public ResponseEntity<Void> followBlog(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable long blogId
    ) {
        blogService.followBlog(
                blogService.getBlogId(userDetails.getMemberId()),
                blogId
        );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{blogId}/follow")
    public ResponseEntity<Void> unfollowBlog(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable long blogId
    ) {
        blogService.unfollowBlog(
                blogService.getBlogId(userDetails.getMemberId()),
                blogId
        );
        return ResponseEntity.noContent().build();
    }
}
