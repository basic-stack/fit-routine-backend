package kr.co.khedu.fitroutine.post.mapper;

import kr.co.khedu.fitroutine.post.model.dto.ReplyCreateRequest;
import kr.co.khedu.fitroutine.post.model.dto.ReplyDetail;
import kr.co.khedu.fitroutine.post.model.dto.ReplyLikesResponse;
import kr.co.khedu.fitroutine.post.model.dto.ReplyResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.lang.Nullable;

import java.util.List;

@Mapper
public interface PostReplyMapper {
    List<? extends ReplyResponse> selectRepliesByPostId(long postId);

    @Nullable ReplyResponse selectReplyById(long replyId);

    int existsReplyByMemberId(long replyId, long memberId);

    int existsChildReplies(long replyId);

    void insertReply(long postId, long memberId, ReplyCreateRequest createRequest);

    int deleteReply(long replyId);

    @Nullable ReplyLikesResponse selectReplyLikes(long memberId, long replyId);

    int likeReply(long memberId, long replyId);

    int unlikeReply(long memberId, long replyId);

    ReplyDetail getReplyDetail(long replyId);

    int checkPermissionPost(long memberId, long replyId);

    int updateReply(long memberId, long replyId, String content);
}
