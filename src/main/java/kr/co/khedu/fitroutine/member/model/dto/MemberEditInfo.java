package kr.co.khedu.fitroutine.member.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberEditInfo {
    private long memberId;
    private String nickname;
    private String password;
    private String newPassword;
    private String checkPassword;
    private String phone;
    private int height;
    private int weight;

    @Builder
    public MemberEditInfo(
            long memberId,
            String nickname,
            String password,
            String newPassword,
            String checkPassword,
            String phone,
            int height,
            int weight) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.password = password;
        this.newPassword = newPassword;
        this.checkPassword = checkPassword;
        this.phone = phone;
        this.height = height;
        this.weight = weight;
    }
}
