package com.saju.api.auth.entity;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String username;
    private String password;
}