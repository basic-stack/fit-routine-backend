package kr.co.khedu.fitroutine.post.mapper;

import kr.co.khedu.fitroutine.post.model.dto.PopularPost;
import kr.co.khedu.fitroutine.post.model.dto.PostCreateRequest;
import kr.co.khedu.fitroutine.post.model.dto.PostResponse;
import kr.co.khedu.fitroutine.post.model.dto.PostUpdateRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.lang.Nullable;

import java.util.List;

@Mapper
public interface PostMapper {
    List<? extends PostResponse> selectPostsByBlogId(long blogId, int offset, int size);

    @Nullable PostResponse selectPostById(long postId);

    int existsPostByMemberId(long postId, long memberId);

    void insertPost(long blogId, PostCreateRequest createRequest);

    int updatePost(long postId, PostUpdateRequest updateRequest);

    int deletePost(long postId);

    List<? extends PopularPost> getPopularPostTop3();
}
