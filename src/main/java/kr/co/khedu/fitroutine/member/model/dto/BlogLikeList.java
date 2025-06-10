package kr.co.khedu.fitroutine.member.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
public final class BlogLikeList {
    private final long memberId;
    private final String nickname;
    private final char gender;
    private final int grade;

    @Builder
    private BlogLikeList(long memberId, String nickname, char gender, int grade) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.gender = gender;
        this.grade = grade;
    }
}
