package kr.co.khedu.fitroutine.auth.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public final class LoginRequest {
    private final String email;
    private final String password;

    @Builder
    private LoginRequest(
            String email,
            String password
    ) {
        this.email = email;
        this.password = password;
    }
}
