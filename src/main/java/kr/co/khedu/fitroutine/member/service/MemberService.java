package kr.co.khedu.fitroutine.member.service;

import kr.co.khedu.fitroutine.member.mapper.MemberMapper;
import kr.co.khedu.fitroutine.member.model.dto.BlogLikeList;
import kr.co.khedu.fitroutine.member.model.dto.MemberEditInfo;
import kr.co.khedu.fitroutine.member.model.dto.MemberProfile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public MemberProfile getMemberProfile(long memberId) {
        MemberProfile memberProfile = memberMapper.getMemberProfile(memberId);
        if (memberProfile == null) {
            throw new IllegalStateException("회원을 찾을 수 없습니다: " + memberId);
        }

        return memberProfile;
    }

    @Transactional
    public boolean editMemberProfile(MemberEditInfo memberEditInfo) {
        boolean result = true;
        if (memberEditInfo.getNickname() != null ||
                memberEditInfo.getPhone() != null ||
                memberEditInfo.getNewPassword() != null
        ) {
            if (memberMapper.editMemberProfile(memberEditInfo) <= 0) {
                result = false;
            }
        }

        if (memberEditInfo.getHeight() != null ||
                memberEditInfo.getWeight() != null
        ) {
            if (memberMapper.updateMemberDetail(memberEditInfo) <= 0) {
                result = false;
            }
        }

        return result;
    }

    public List<? extends BlogLikeList> getLikeList(long memberId) {
        return memberMapper.getLikeList(memberId);
    }

    public boolean deleteLike(long memberId, long loginedId) { return memberMapper.deleteLike(memberId, loginedId) > 0; }
}
