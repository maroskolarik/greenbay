package com.gfa.backend.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void test_createEntity() {
        User actual = new User("username", "password");

        assertNull(actual.getId());
        assertEquals("username", actual.getUsername());
        assertEquals("password", actual.getPassword());
    }
}