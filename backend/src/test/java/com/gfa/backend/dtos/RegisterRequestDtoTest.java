package com.gfa.backend.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterRequestDtoTest {
    @Test
    void test_createEntity() {
        RegisterRequestDto actual = new RegisterRequestDto("username", "password");

        assertEquals("username", actual.getUsername());
        assertEquals("password", actual.getPassword());
    }
}