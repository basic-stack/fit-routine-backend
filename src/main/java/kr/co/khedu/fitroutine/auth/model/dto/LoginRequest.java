package kr.co.khedu.fitroutine.auth.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
public final class LoginRequest {
    @NotBlank
    private final String email;

    @NotBlank
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
