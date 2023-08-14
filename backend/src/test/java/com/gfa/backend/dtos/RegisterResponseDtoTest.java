package com.gfa.backend.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterResponseDtoTest {
    @Test
    void test_createEntity() {
        RegisterResponseDto actual = new RegisterResponseDto("ok");

        assertEquals("ok", actual.getStatus());
    }
}