package kr.co.khedu.fitroutine.member.service;

import kr.co.khedu.fitroutine.member.mapper.MemberMapper;
import kr.co.khedu.fitroutine.member.model.dto.BlogLikeList;
import kr.co.khedu.fitroutine.member.model.dto.MemberProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class MemberService {
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public MemberProfile getMemberProfile(long memberId) {
        return memberMapper.getMemberProfile(memberId);
    }

    public List<? extends BlogLikeList> getLikeList(long memberId) {
        return memberMapper.getLikeList(memberId);
    }

    public boolean deleteLike(long memberId, long loginedId) { return memberMapper.deleteLike(memberId, loginedId) > 0; }
}
