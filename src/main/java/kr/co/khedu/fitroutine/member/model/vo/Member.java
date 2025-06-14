package kr.co.khedu.fitroutine.member.model.vo;

import kr.co.khedu.fitroutine.member.model.dto.MemberGender;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public final class Member {
    private final long memberId;
    private final String email;
    private final String password;
    private final String nickname;
    private final MemberGender gender;
    private final LocalDate birthAt;
    private final String phone;
    private final LocalDate createdAt;
    private final boolean isDeleted;

    @Builder
    private Member(
            long memberId,
            String email,
            String password,
            String nickname,
            MemberGender gender,
            LocalDate birthAt,
            String phone,
            LocalDate createdAt,
            boolean isDeleted
    ) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.birthAt = birthAt;
        this.phone = phone;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }
}
