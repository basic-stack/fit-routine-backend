package kr.co.khedu.fitroutine.auth.service;

import kr.co.khedu.fitroutine.auth.model.dto.LoginRequest;
import kr.co.khedu.fitroutine.auth.model.dto.LoginResponse;
import kr.co.khedu.fitroutine.member.mapper.MemberMapper;
import kr.co.khedu.fitroutine.member.model.vo.Member;
import kr.co.khedu.fitroutine.security.jwt.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(
            MemberMapper memberMapper,
            PasswordEncoder passwordEncoder,
            JwtTokenProvider jwtTokenProvider
    ) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public LoginResponse login(LoginRequest request) {
        Member member = memberMapper.findMemberByEmail(request.getEmail());

        if (member == null || !passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new IllegalStateException("이메일 또는 비밀번호가 틀렸습니다.");
        }

        return LoginResponse.builder()
                .accessToken(jwtTokenProvider.generateToken(member.getEmail()))
                .build();
    }
}
