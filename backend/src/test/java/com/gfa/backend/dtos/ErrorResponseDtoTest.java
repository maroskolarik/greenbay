package com.gfa.backend.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseDtoTest {
    @Test
    void test_createEntity() {
        ErrorResponseDto actual = new ErrorResponseDto("error");

        assertEquals("error", actual.getError());
    }
}