package kr.co.khedu.fitroutine.security.model.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public final class UserDetailsImpl implements UserDetails {
    private final long memberId;
    private final String email;
    private final String password;

    @Builder
    private UserDetailsImpl(
            long memberId,
            String email,
            String password
    ) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
