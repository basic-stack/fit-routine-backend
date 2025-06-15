package kr.co.khedu.fitroutine.post.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public final class PostResponse {
    private final long postId;
    private final String title;
    private final String content;
    private final String category;
    private final LocalDateTime createdAt;
    private final long blogId;
    private final String nickname;

    @Builder
    private PostResponse(
            long postId,
            String title,
            String content,
            String category,
            LocalDateTime createdAt,
            long blogId,
            String nickname
    ) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.category = category;
        this.createdAt = createdAt;
        this.blogId = blogId;
        this.nickname = nickname;
    }
}
