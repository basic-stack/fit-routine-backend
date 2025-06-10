package kr.co.khedu.fitroutine.member.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class MemberEditInfo {
    private Long memberId;
    private final String nickname;
    private final String newPassword;
    private final String phone;
    private final Integer height;
    private final Integer weight;

    @Builder
    private MemberEditInfo(
            Long memberId,
            String nickname,
            String newPassword,
            String phone,
            Integer height,
            Integer weight
    ) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.newPassword = newPassword;
        this.phone = phone;
        this.height = height;
        this.weight = weight;
    }
}
