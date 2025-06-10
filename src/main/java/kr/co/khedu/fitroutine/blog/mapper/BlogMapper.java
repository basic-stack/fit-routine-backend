package kr.co.khedu.fitroutine.blog.mapper;

import jakarta.annotation.Nullable;
import kr.co.khedu.fitroutine.blog.model.dto.BlogDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {
    @Nullable BlogDetail getBlogDetail(long blogId, long viewerId);

    int unlikeBlog(long memberId, long viewerId);

    int likeBlog(long memberId, long viewerId);

    int updateIntroduce(long blogId, long editorId, String intro);
}
