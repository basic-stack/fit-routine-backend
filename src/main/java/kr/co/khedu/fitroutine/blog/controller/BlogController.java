package kr.co.khedu.fitroutine.blog.controller;

import kr.co.khedu.fitroutine.blog.model.dto.BlogDetail;
import kr.co.khedu.fitroutine.blog.model.dto.IntroduceEdit;
import kr.co.khedu.fitroutine.blog.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blogs")
public final class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/{blogId}")
    public BlogDetail getBlogDetail(@PathVariable long blogId) {
        // 토큰 서비스 추가 시 수정
        long viewerId = 4;
        return blogService.getBlogDetail(blogId, viewerId);
    }

    @DeleteMapping("/{blogId}/likes")
    public String unlikeBlog(
            @PathVariable long blogId,
            @RequestHeader("Authorization") String token
    ) {
        // 추후 토큰으로 로그인 유저 memberId만 추출
        long viewerId = Integer.parseInt(token); // 추후 변경 예정

        return blogService.unlikeBlog(blogId, viewerId) ? "success" : "failure";
    }

    @PostMapping("/{blogId}/likes")
    public String likeBlog(
            @PathVariable long blogId,
            @RequestHeader("Authorization") String token
    ) {
        // 추후 토큰으로 로그인 유저 memberId만 추출
        long viewerId = Integer.parseInt(token); // 추후 변경 예정

        return blogService.likeBlog(blogId, viewerId)  ? "success" : "failure";
    }

    @PutMapping("/{blogId}")
    public ResponseEntity<?> updateBlogIntro(
            @PathVariable long blogId,
            @RequestHeader("Authorization") String token,
            @RequestBody IntroduceEdit introduce
    ) {
        long editorId = Integer.parseInt(token);

        String intro = introduce.getIntroduce();

        return blogService.updateIntroduce(blogId, editorId, intro) ?
                    ResponseEntity.ok("success") :
                    ResponseEntity.status(500).body("failure");
    }

}
