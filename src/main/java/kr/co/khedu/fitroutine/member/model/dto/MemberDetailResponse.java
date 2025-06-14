package kr.co.khedu.fitroutine.member.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public final class MemberDetailResponse {
    private final double height;
    private final double weight;
    private final LocalDate birthAt;
    private final MemberGender gender;

    @Builder
    private MemberDetailResponse(
            double height,
            double weight,
            LocalDate birthAt,
            MemberGender gender
    ) {
        this.height = height;
        this.weight = weight;
        this.birthAt = birthAt;
        this.gender = gender;
    }
}
