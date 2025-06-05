package kr.co.khedu.fitroutine.member.service;

import kr.co.khedu.fitroutine.member.mapper.MemberMapper;
import kr.co.khedu.fitroutine.member.model.dto.MemberEditInfo;
import kr.co.khedu.fitroutine.member.model.dto.MemberProfile;
import org.springframework.stereotype.Service;

@Service
public final class MemberService {
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public MemberProfile getMemberProfile(long memberId) {
        return memberMapper.getMemberProfile(memberId);
    }

    public boolean editMemberProfile(MemberEditInfo memberEditInfo) {
        return memberMapper.editMemberProfile(memberEditInfo) > 0;
    }
}
