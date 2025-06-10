package kr.co.khedu.fitroutine.member.mapper;

import jakarta.annotation.Nullable;
import kr.co.khedu.fitroutine.member.model.dto.MemberEditInfo;
import kr.co.khedu.fitroutine.member.model.dto.BlogLikeList;
import kr.co.khedu.fitroutine.member.model.dto.MemberProfile;
import kr.co.khedu.fitroutine.member.model.vo.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Nullable MemberProfile getMemberProfile(long memberId);

    @Nullable Member findMemberByBlogId(long blogId);

    @Nullable Member findMemberByEmail(String email);

    int editMemberProfile(MemberEditInfo memberEditInfo);

    int updateMemberDetail(MemberEditInfo memberEditInfo);

    List<? extends BlogLikeList> getLikeList(long memberId);

    int deleteLike(long memberId, long loginedId);
}
