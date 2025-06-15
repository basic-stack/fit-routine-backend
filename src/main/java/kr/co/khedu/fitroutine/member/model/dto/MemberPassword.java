package kr.co.khedu.fitroutine.member.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public final class MemberPassword {
    private String password;

    @Builder
    private MemberPassword(String password) {
        this.password = password;
    }
}
