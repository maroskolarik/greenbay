package com.gfa.backend.dtos;

import com.gfa.backend.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginResponseDtoTest {
    @Test
    void test_createEntity() {
        LoginResponseDto actual = new LoginResponseDto("ok", "token");

        assertEquals("ok", actual.getStatus());
        assertEquals("token", actual.getToken());
    }
}