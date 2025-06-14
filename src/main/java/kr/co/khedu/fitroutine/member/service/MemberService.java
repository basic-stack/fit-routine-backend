package kr.co.khedu.fitroutine.member.service;

import kr.co.khedu.fitroutine.member.mapper.MemberMapper;
import kr.co.khedu.fitroutine.member.model.dto.MemberUpdateRequest;
import kr.co.khedu.fitroutine.member.model.dto.MemberResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public MemberResponse getMember(long memberId) {
        MemberResponse memberResponse = memberMapper.selectMemberById(memberId);
        if (memberResponse == null) {
            throw new IllegalStateException("회원을 찾을 수 없습니다: " + memberId);
        }

        return memberResponse;
    }

    @Transactional
    public MemberResponse updateMember(long memberId, MemberUpdateRequest updateRequest) {
        if (updateRequest.getNickname() != null ||
                updateRequest.getPhone() != null ||
                updateRequest.getNewPassword() != null
        ) {
            if (memberMapper.updateMember(memberId, updateRequest) != 0) {
                throw new IllegalStateException("회원 프로필을 수정할 수 없습니다.");
            }
        }

        if (updateRequest.getHeight() != null ||
                updateRequest.getWeight() != null
        ) {
            if (memberMapper.updateMemberDetail(memberId, updateRequest) <= 0) {
                throw new IllegalStateException("회원 상세 정보를 수정할 수 없습니다.");
            }
        }

        return getMember(memberId);
    }
}
