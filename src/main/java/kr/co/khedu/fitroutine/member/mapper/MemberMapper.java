package kr.co.khedu.fitroutine.member.mapper;

import kr.co.khedu.fitroutine.member.model.dto.BlogLikeList;
import kr.co.khedu.fitroutine.member.model.dto.MemberProfile;
import kr.co.khedu.fitroutine.member.model.vo.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    Member findMemberById(long memberId);

    MemberProfile getMemberProfile(long memberId);

    List<? extends BlogLikeList> getLikeList(long memberId);

    int deleteLike(long memberId, long loginedId);
}
