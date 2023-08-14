package com.gfa.backend.dtos;

import com.gfa.backend.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginRequestDtoTest {
    @Test
    void test_createEntity() {
        LoginRequestDto actual = new LoginRequestDto("username", "password");

        assertEquals("username", actual.getUsername());
        assertEquals("password", actual.getPassword());
    }
}