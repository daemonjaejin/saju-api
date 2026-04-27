package com.saju.api.security;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RedisTemplate<String, String> redisTemplate;

    private static final String PREFIX = "refresh:";  // Redis Key 접두사

    // 저장: refresh:{username} = refreshToken (7일 TTL)
    public void save(String username, String refreshToken, long expiration) {
        redisTemplate.opsForValue().set(
                PREFIX + username,
                refreshToken,
                expiration,
                TimeUnit.MILLISECONDS
        );
    }

    // 조회
    public String get(String username) {
        return redisTemplate.opsForValue().get(PREFIX + username);
    }

    // 삭제 (로그아웃 시)
    public void delete(String username) {
        redisTemplate.delete(PREFIX + username);
    }

    // 유효성 검사 (Redis에 저장된 토큰과 일치하는지)
    public boolean validate(String username, String refreshToken) {
        String saved = get(username);
        return saved != null && saved.equals(refreshToken);
    }
}
