package kr.co.khedu.fitroutine.member.model.dto;

import kr.co.khedu.fitroutine.member.validator.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;

@Getter
public final class MemberUpdateRequest {
    @ValidNickname
    private final @Nullable String nickname;

    @ValidPassword
    private final @Nullable String newPassword;

    @ValidPhone
    private final @Nullable String phone;

    @ValidHeight
    private final @Nullable Integer height;

    @ValidWeight
    private final @Nullable Integer weight;

    @Builder
    private MemberUpdateRequest(
            @Nullable String nickname,
            @Nullable String newPassword,
            @Nullable String phone,
            @Nullable Integer height,
            @Nullable Integer weight
    ) {
        this.nickname = nickname;
        this.newPassword = newPassword;
        this.phone = phone;
        this.height = height;
        this.weight = weight;
    }
}
