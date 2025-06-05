package kr.co.khedu.fitroutine.member.service;

import kr.co.khedu.fitroutine.member.mapper.MemberMapper;
import kr.co.khedu.fitroutine.member.model.dto.MemberEditInfo;
import kr.co.khedu.fitroutine.member.model.dto.MemberProfile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public MemberProfile getMemberProfile(long memberId) {
        return memberMapper.getMemberProfile(memberId);
    }

    @Transactional
    public boolean editMemberProfile(MemberEditInfo memberEditInfo) {
        System.out.println("Service에 요청은 들어옴");
        int result1 = memberMapper.editMemberProfile(memberEditInfo);
        System.out.println("Service에서 result1 성공");
        if (result1 <= 0) {
            System.out.println("Service에서 result1 실패");
            return false;
        }

        if (memberEditInfo.getHeight() != null || memberEditInfo.getWeight() != null) {
            int result2 = memberMapper.updateMemberDetail(memberEditInfo);
            if (result2 <= 0) {
                System.out.println("Service에서 result2 실패");
                return false;
            }
            System.out.println("Service에서 result2 성공");
        }

        return true;
    }
}
