package kr.co.khedu.fitroutine.member.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public final class MemberResponse {
    private final String email;
    private final String nickname;
    private final String birthAt;
    private final String phone;
    private final MemberGender gender;
    private final int height;
    private final int weight;

    @Builder
    private MemberResponse(
            String email,
            String nickname,
            String birthAt,
            String phone,
            MemberGender gender,
            int height,
            int weight
    ) {
        this.email = email;
        this.nickname = nickname;
        this.birthAt = birthAt;
        this.phone = phone;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }
}
