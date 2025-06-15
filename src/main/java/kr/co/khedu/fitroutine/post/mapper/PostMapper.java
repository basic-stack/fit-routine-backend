package kr.co.khedu.fitroutine.post.mapper;

import kr.co.khedu.fitroutine.post.model.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.lang.Nullable;

import java.util.List;

@Mapper
public interface PostMapper {
    List<? extends PostResponse> selectPostsByBlogId(
            @Nullable Long blogId,
            int offset,
            int size,
            PostSort sort,
            PostSortOrder order
    );

    @Nullable PostResponse selectPostById(long postId);

    int existsPostByMemberId(long postId, long memberId);

    void insertPost(long blogId, PostCreateRequest createRequest);

    int updatePost(long postId, PostUpdateRequest updateRequest);

    int deletePost(long postId);

    @Nullable PostLikesResponse selectPostLikes(long memberId, long postId);

    int likePost(long memberId, long postId);

    int unlikePost(long memberId, long postId);

    int checkPermissionPost(long memberId, long postId);
}
