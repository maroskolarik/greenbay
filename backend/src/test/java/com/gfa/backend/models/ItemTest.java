package com.gfa.backend.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void test_createEntity() {
        Item actual = new Item("picture", "description", "url", 100, 200);

        assertNull(actual.getId());
        assertEquals("picture", actual.getName());
        assertEquals("description", actual.getDescription());
        assertEquals("url", actual.getPhotoUrl());
        assertEquals(100, actual.getStartingPrice());
        assertEquals(200, actual.getPurchasePrice());
    }
}