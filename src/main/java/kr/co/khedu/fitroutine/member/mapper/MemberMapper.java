package kr.co.khedu.fitroutine.member.mapper;

import kr.co.khedu.fitroutine.member.model.dto.MemberEditInfo;
import kr.co.khedu.fitroutine.member.model.dto.MemberProfile;
import kr.co.khedu.fitroutine.member.model.vo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member findMemberByBlogId(long blogId);

    MemberProfile getMemberProfile(long memberId);

    int editMemberProfile(MemberEditInfo memberEditInfo);

    int updateMemberDetail(MemberEditInfo memberEditInfo);
}
