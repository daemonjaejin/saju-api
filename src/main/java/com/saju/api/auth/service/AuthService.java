package com.saju.api.auth.service;

import com.saju.api.auth.dto.TokenResponse;
import com.saju.api.auth.entity.LoginRequest;
import com.saju.api.security.JwtTokenProvider;
import com.saju.api.security.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenService refreshTokenService;

    // 로그인
    public TokenResponse login(LoginRequest request) {
        // ID/PW 검증
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword())
        );

        String username = authentication.getName();
        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        // 토큰 발급
        String accessToken = jwtTokenProvider.createAccessToken(username, roles);
        String refreshToken = jwtTokenProvider.createRefreshToken(username);

        // RefreshToken Redis 저장
        refreshTokenService.save(username, refreshToken,
                jwtTokenProvider.getRefreshExpiration());

        return new TokenResponse(accessToken, refreshToken);
    }

    // AccessToken 재발급
    public TokenResponse refresh(String refreshToken) {
        if (!jwtTokenProvider.validateToken(refreshToken)) {
            throw new RuntimeException("유효하지 않은 RefreshToken");
        }

        String username = jwtTokenProvider.getUsername(refreshToken);

        // Redis에 저장된 토큰과 일치하는지 확인
        if (!refreshTokenService.validate(username, refreshToken)) {
            throw new RuntimeException("RefreshToken 불일치 (이미 로그아웃된 사용자)");
        }

        // 새 AccessToken 발급
        String newAccessToken = jwtTokenProvider.createAccessToken(
                username, Collections.emptyList());

        return new TokenResponse(newAccessToken, refreshToken);
    }

    // 로그아웃
    public void logout(String username) {
        refreshTokenService.delete(username);  // Redis에서 삭제
    }
}
