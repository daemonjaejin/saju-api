package com.saju.api.security;

import com.saju.api.user.dto.UserResult;
import com.saju.api.user.entity.UserEntity;
import com.saju.api.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = new UserEntity();
        entity.setUserId(username);

        UserResult user = userMapper.userDetail(entity);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        String role = user.getRoleId();
        if (role == null || role.isBlank()) {
            role = "ROLE_USER";
        } else if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }

        return User.builder()
                .username(user.getUserId())
                .password(user.getPassword())
                .authorities(List.of(new SimpleGrantedAuthority(role)))
                .build();
    }
}
