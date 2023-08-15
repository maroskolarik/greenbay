package com.gfa.backend.dtos;

public class LoginResponseDto {
    private final String status;
    private final Integer dollars;
    private final String token;

    public LoginResponseDto(String status, String token, Integer dollars) {
        this.status = status;
        this.token = token;
        this.dollars = dollars;
    }

    public String getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public Integer getDollars() {
        return dollars;
    }
}
