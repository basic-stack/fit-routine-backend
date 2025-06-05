package kr.co.khedu.fitroutine.member.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberEditInfo {
    private long memberId;
    private String nickname;
    private String newPassword;
    private String phone;
    private Integer height;
    private Integer weight;

    @Builder
    public MemberEditInfo(
            long memberId,
            String nickname,
            String newPassword,
            String phone,
            Integer height,
            Integer weight) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.newPassword = newPassword;
        this.phone = phone;
        this.height = height;
        this.weight = weight;
    }
}
