package com.gfa.backend.dtos;

public class LoginResponseDto {
    private final String status;
    private final String token;

    public LoginResponseDto(String status, String token) {
        this.status = status;
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }
}
