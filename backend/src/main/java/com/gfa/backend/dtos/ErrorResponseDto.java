package com.gfa.backend.dtos;

public class ErrorResponseDto {
    public final String error;

    public ErrorResponseDto(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
