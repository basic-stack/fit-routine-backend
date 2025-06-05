package kr.co.khedu.fitroutine.blog.mapper;

import kr.co.khedu.fitroutine.blog.model.dto.BlogDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {
    BlogDetail getBlogDetail(long blogId, long viewerId);

    int unlikeBlog(long blogId, long viewerId);

    int likeBlog(long blogId, long viewerId);
}
