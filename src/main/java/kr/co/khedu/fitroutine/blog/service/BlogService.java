package kr.co.khedu.fitroutine.blog.service;

import kr.co.khedu.fitroutine.blog.mapper.BlogMapper;
import kr.co.khedu.fitroutine.blog.model.dto.BlogDetail;
import kr.co.khedu.fitroutine.member.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public final class BlogService {
    private final BlogMapper blogMapper;
    private final MemberMapper memberMapper;

    public BlogService(BlogMapper blogMapper, MemberMapper memberMapper) {
        this.blogMapper = blogMapper;
        this.memberMapper = memberMapper;
    }

    public BlogDetail getBlogDetail(long blogId, long viewerId) {
        BlogDetail blogDetail = blogMapper.getBlogDetail(blogId, viewerId);
        if (blogDetail == null) {
            throw new IllegalStateException("블로그를 찾을 수 없습니다: " + blogId);
        }

        return blogDetail;
    }

    public boolean unlikeBlog(long blogId, long viewerId) {
        return blogMapper.unlikeBlog(
                memberMapper.findMemberByBlogId(blogId).getMemberId(),
                viewerId
        ) > 0;
    }

    public boolean likeBlog(long blogId, long viewerId) {
        return blogMapper.likeBlog(
                memberMapper.findMemberByBlogId(blogId).getMemberId(),
                viewerId
        ) > 0;
    }

    public boolean updateIntroduce(long blogId, long editorId, String intro) {
        return blogMapper.updateIntroduce(blogId, editorId, intro) > 0;
    }
}
