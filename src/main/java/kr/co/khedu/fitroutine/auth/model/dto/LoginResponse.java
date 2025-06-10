package kr.co.khedu.fitroutine.auth.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public final class LoginResponse {
    private final String accessToken;

    @Builder
    private LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
