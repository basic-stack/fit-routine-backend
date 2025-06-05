package kr.co.khedu.fitroutine.blog.service;

import kr.co.khedu.fitroutine.blog.mapper.BlogMapper;
import kr.co.khedu.fitroutine.blog.model.dto.BlogDetail;
import org.springframework.stereotype.Service;

@Service
public final class BlogService {
    private final BlogMapper blogMapper;

    public BlogService(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    public BlogDetail getBlogDetail(long blogId, long viewerId) {
        BlogDetail blogDetail = blogMapper.getBlogDetail(blogId, viewerId);
        if (blogDetail == null) {
            throw new IllegalStateException("블로그를 찾을 수 없습니다: " + blogId);
        }

        return blogDetail;
    }

    public boolean unlikeBlog(long blogId, long viewerId) {
        return blogMapper.unlikeBlog(blogId, viewerId) > 0;
    }

    public boolean likeBlog(long blogId, long viewerId) {
        return blogMapper.likeBlog(blogId, viewerId) > 0;
    }
}
