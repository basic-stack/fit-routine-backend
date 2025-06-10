package kr.co.khedu.fitroutine.security.service;

import kr.co.khedu.fitroutine.member.mapper.MemberMapper;
import kr.co.khedu.fitroutine.member.model.vo.Member;
import kr.co.khedu.fitroutine.security.model.dto.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public final class UserDetailsServiceImpl implements UserDetailsService {
    private final MemberMapper memberMapper;

    public UserDetailsServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberMapper.findMemberByEmail(username);

        if (member == null) {
            throw new UsernameNotFoundException(username);
        }

        return UserDetailsImpl.builder()
                .memberId(member.getMemberId())
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
