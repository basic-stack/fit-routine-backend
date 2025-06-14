package kr.co.khedu.fitroutine.member.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public final class MemberCreateResponse {
    private final String nickname;

    @Builder
    private MemberCreateResponse(String nickname) {
        this.nickname = nickname;
    }
}
