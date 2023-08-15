package com.gfa.backend.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginResponseDtoTest {
    @Test
    void test_createEntity() {
        LoginResponseDto actual = new LoginResponseDto("ok", "token", 100);

        assertEquals("ok", actual.getStatus());
        assertEquals("token", actual.getToken());
        assertEquals(100, actual.getDollars());
    }
}