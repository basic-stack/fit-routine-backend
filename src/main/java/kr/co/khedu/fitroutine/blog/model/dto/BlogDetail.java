package kr.co.khedu.fitroutine.blog.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public final class BlogDetail {
    private final long blogId;
    private final String nickname;
    private final int grade;
    private final String introduce;
    private final String gender;
    private final int likeCount;
    private final boolean liked;

    @Builder
    private BlogDetail(
            long blogId,
            String nickname,
            int grade,
            String introduce,
            String gender,
            int likeCount,
            boolean liked
    ) {
        this.blogId = blogId;
        this.nickname = nickname;
        this.grade = grade;
        this.introduce = introduce;
        this.gender = gender;
        this.likeCount = likeCount;
        this.liked = liked;
    }
}
