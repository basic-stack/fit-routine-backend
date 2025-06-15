package kr.co.khedu.fitroutine.member.service;

import kr.co.khedu.fitroutine.member.mapper.MemberMapper;
import kr.co.khedu.fitroutine.member.model.dto.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    public MemberService(
            MemberMapper memberMapper,
            PasswordEncoder passwordEncoder
    ) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public MemberResponse getMember(long memberId) {
        MemberResponse memberResponse = memberMapper.selectMemberById(memberId);
        if (memberResponse == null) {
            throw new IllegalStateException("회원을 찾을 수 없습니다: " + memberId);
        }

        return memberResponse;
    }

    public MemberCreateResponse createMember(MemberCreateRequest createRequest) {
        createRequest.setPassword(passwordEncoder.encode(createRequest.getPassword()));

        if (memberMapper.insertMember(createRequest) != 1 ||
                memberMapper.insertMemberDetail(createRequest) != 1 ||
                createRequest.getMemberId() == null
        ) {
            throw new IllegalStateException("회원을 생성할 수 없습니다.");
        }

        return MemberCreateResponse.builder()
                .nickname(
                        getMember(createRequest.getMemberId()).getNickname()
                )
                .build();
    }

    public MemberResponse updateMember(long memberId, MemberUpdateRequest updateRequest) {
        if (updateRequest.getNickname() != null ||
                updateRequest.getPhone() != null ||
                updateRequest.getNewPassword() != null
        ) {
            if (memberMapper.updateMember(memberId, updateRequest) <= 0) {
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

    public boolean checkCurrentPassword(long memberId, MemberPassword password) {
        String inputPassword = password.getPassword(); // 입력값
        MemberPassword storedPassword = memberMapper.selectCurrentPassword(memberId); // DB에서 조회한 값

        return passwordEncoder.matches(inputPassword, storedPassword.getPassword());
    }
}
