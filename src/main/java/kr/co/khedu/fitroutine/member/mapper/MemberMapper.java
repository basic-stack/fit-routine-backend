package kr.co.khedu.fitroutine.member.mapper;

import jakarta.annotation.Nullable;
import kr.co.khedu.fitroutine.member.model.dto.MemberCreateRequest;
import kr.co.khedu.fitroutine.member.model.dto.MemberDetailResponse;
import kr.co.khedu.fitroutine.member.model.dto.MemberUpdateRequest;
import kr.co.khedu.fitroutine.member.model.dto.MemberResponse;
import kr.co.khedu.fitroutine.member.model.vo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    @Nullable MemberResponse selectMemberById(long memberId);

    @Nullable MemberDetailResponse selectMemberDetailById(long memberId);

    @Nullable Member selectMemberByEmail(String email);

    int insertMember(MemberCreateRequest createRequest);

    int insertMemberDetail(MemberCreateRequest createRequest);

    int updateMember(long memberId, MemberUpdateRequest updateRequest);

    int updateMemberDetail(long memberId, MemberUpdateRequest updateRequest);
}
