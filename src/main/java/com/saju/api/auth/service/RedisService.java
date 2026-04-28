package com.saju.api.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    // 저장 (key: "RT:userId", value: refreshToken)
    public void saveRefreshToken(String userId, String refreshToken, long expirationMs) {
        redisTemplate.opsForValue().set(
                "RT:" + userId,
                refreshToken,
                expirationMs,
                TimeUnit.MILLISECONDS
        );
    }

    // 조회
    public String getRefreshToken(String userId) {
        return redisTemplate.opsForValue().get("RT:" + userId);
    }

    // 삭제 (로그아웃)
    public void deleteRefreshToken(String userId) {
        redisTemplate.delete("RT:" + userId);
    }

    // 존재 여부
    public boolean hasRefreshToken(String userId) {
        return Boolean.TRUE.equals(redisTemplate.hasKey("RT:" + userId));
    }
}