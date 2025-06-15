package kr.co.khedu.fitroutine.post.service;

import kr.co.khedu.fitroutine.post.mapper.PostReplyMapper;
import kr.co.khedu.fitroutine.post.model.dto.ReplyCreateRequest;
import kr.co.khedu.fitroutine.post.model.dto.ReplyDetail;
import kr.co.khedu.fitroutine.post.model.dto.ReplyLikesResponse;
import kr.co.khedu.fitroutine.post.model.dto.ReplyResponse;
import kr.co.khedu.fitroutine.security.model.dto.UserDetailsImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PostReplyService {
    private final PostReplyMapper postReplyMapper;

    public PostReplyService(PostReplyMapper postReplyMapper) {
        this.postReplyMapper = postReplyMapper;
    }

    @Transactional(readOnly = true)
    public List<? extends ReplyResponse> getReplies(long postId) {
        return postReplyMapper.selectRepliesByPostId(postId);
    }

    @Transactional(readOnly = true)
    public ReplyResponse getReply(long replyId) {
        return postReplyMapper.selectReplyById(replyId);
    }

    @Transactional(readOnly = true)
    public boolean isReplyOwner(long replyId, UserDetailsImpl userDetails) {
        return postReplyMapper.existsReplyByMemberId(
                replyId,
                userDetails.getMemberId()
        ) == 1;
    }

    public ReplyResponse createReply(long postId, long memberId, ReplyCreateRequest createRequest) {
        Long parentId = createRequest.getParentId();
        if (parentId != null) {
            ReplyResponse replyResponse = postReplyMapper.selectReplyById(parentId);
            if (replyResponse == null) {
                throw new IllegalArgumentException("댓글의 지정된 부모가 유효하지 않습니다.");
            }

            if (replyResponse.getParentId() != null) {
                throw new IllegalArgumentException("댓글의 지정된 부모는 고아여야 합니다.");
            }

            if (replyResponse.getPostId() != postId) {
                throw new IllegalArgumentException("댓글의 지정된 부모가 다른 포스트에 있습니다.");
            }
        }

        postReplyMapper.insertReply(postId, memberId, createRequest);

        Long replyId = createRequest.getReplyId();
        if (replyId == null) {
            throw new IllegalStateException("댓글을 추가할 수 없습니다.");
        }

        return getReply(replyId);
    }

    public void deleteReply(long replyId) {
        if (postReplyMapper.existsChildReplies(replyId) == 1) {
            throw new IllegalStateException("댓글에 자식이 존재합니다. id=" + replyId);
        }

        if (postReplyMapper.deleteReply(replyId) != 1) {
            throw new NoSuchElementException("댓글이 존재하지 않습니다. id=" + replyId);
        }
    }

    public ReplyLikesResponse getReplyLikes(long memberId, long postId) {
        ReplyLikesResponse postLikesResponse = postReplyMapper.selectReplyLikes(memberId, postId);
        if (postLikesResponse == null) {
            throw new IllegalStateException("포스트의 좋아요 목록을 불러올 수 없습니다.");
        }

        return postLikesResponse;
    }

    public void likeReply(long memberId, long postId) {
        if (postReplyMapper.likeReply(memberId, postId) != 1) {
            throw new IllegalStateException("이미 좋아요한 포스트입니다. id=" + postId + ", followed=" + memberId);
        }
    }

    public void unlikeReply(long memberId, long postId) {
        if (postReplyMapper.unlikeReply(memberId, postId) != 1) {
            throw new NoSuchElementException("포스트 좋아요가 존재하지 않습니다. id=" + postId + ", followed=" + memberId);
        }
    }

    public ReplyDetail getReplyDetails(long replyId) {
        ReplyDetail replyDetail = postReplyMapper.getReplyDetail(replyId);
        if(replyDetail == null) {
            throw new NoSuchElementException("댓글이 존재하지 않습니다. id=" + replyId);
        }
        return replyDetail;
    }

    public Boolean checkPermissionReply(long memberId, long replyId) {
        return (postReplyMapper.checkPermissionPost(memberId, replyId) == 1);
    }

    public ReplyResponse updateReply(long memberId, long replyId, String content) {
        int result = postReplyMapper.updateReply(memberId, replyId, content);
        if (result == 0) {
            throw new NoSuchElementException("댓글이 존재하지 않습니다. id=" + replyId);
        }
        return getReply(replyId);
    }
}
