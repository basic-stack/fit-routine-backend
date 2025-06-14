package kr.co.khedu.fitroutine.member.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import kr.co.khedu.fitroutine.member.validator.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@Getter
@Setter
public final class MemberCreateRequest {
    @Null
    private @Nullable Long memberId;

    @ValidEmail
    @NotNull
    private final String email;

    @ValidPassword
    @NotNull
    private String password;

    @ValidNickname
    @NotNull
    private final String nickname;

    @NotNull
    private final MemberGender gender;

    @NotNull
    private final LocalDate birthAt;

    @ValidPhone
    @NotNull
    private final String phone;

    @ValidHeight
    @NotNull
    private final int height;

    @ValidWeight
    @NotNull
    private final int weight;

    @Builder
    private MemberCreateRequest(
            String email,
            String password,
            String nickname,
            MemberGender gender,
            LocalDate birthAt,
            String phone,
            int height,
            int weight
    ) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.birthAt = birthAt;
        this.phone = phone;
        this.height = height;
        this.weight = weight;
    }
}
