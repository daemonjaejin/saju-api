package com.saju.api.auth.entity;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String userId;
    private String password;
}