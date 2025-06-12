package kr.co.khedu.fitroutine.post.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public final class PopularPost {
    private final int postId;
    private final String title;
    private final String nickname;

    @Builder
    private PopularPost(
            int postId,
            String title,
            String nickname
    ) {
        this.postId = postId;
        this.title = title;
        this.nickname = nickname;
    }
}
