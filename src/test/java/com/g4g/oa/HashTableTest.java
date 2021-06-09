package com.g4g.oa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void put() {
        Map hashTable = new HashTable(7);
        assertTrue(hashTable.put(51, "Fifty One"));
        assertTrue(hashTable.put(54, "Fifty Four"));
        assertTrue(hashTable.put(7, "Seven"));
        assertTrue(hashTable.put(14, "Fourteen"));
        assertTrue(hashTable.put(21, "Twenty One"));
        assertTrue(hashTable.put(23, "Twenty Three"));
        assertTrue(hashTable.put(18, "Eighteen"));
        assertFalse(hashTable.put(39, "Thirty Nine"));
    }

    @Test
    void get() {
        Map hashTable = new HashTable(7);
        assertTrue(hashTable.put(51, "Fifty One"));
        assertTrue(hashTable.put(54, "Fifty Four"));
        assertTrue(hashTable.put(7, "Seven"));
        assertTrue(hashTable.put(14, "Fourteen"));
        assertTrue(hashTable.put(21, "Twenty One"));
        assertTrue(hashTable.put(23, "Twenty Three"));
        assertTrue(hashTable.put(18, "Eighteen"));
        assertEquals("Eighteen", hashTable.get(18).value);
        assertEquals("Fifty One", hashTable.get(51).value);
        assertEquals("Fifty Four", hashTable.get(54).value);
        assertEquals("Seven", hashTable.get(7).value);
        assertEquals("Fourteen", hashTable.get(14).value);
        assertEquals("Twenty One", hashTable.get(21).value);
        assertEquals("Twenty Three", hashTable.get(23).value);

        assertNull(hashTable.get(100));
    }

    @Test
    void remove() {
        Map hashTable = new HashTable(7);
        assertTrue(hashTable.put(51, "Fifty One"));
        assertTrue(hashTable.put(54, "Fifty Four"));
        assertTrue(hashTable.put(7, "Seven"));
        assertTrue(hashTable.put(14, "Fourteen"));
        assertTrue(hashTable.put(21, "Twenty One"));
        assertTrue(hashTable.put(23, "Twenty Three"));
        assertTrue(hashTable.put(18, "Eighteen"));
        assertEquals("Eighteen", hashTable.remove(18).value);
        assertNull(hashTable.get(18));
    }

    @Test
    void putRemoveAndPut() {
        Map hashTable = new HashTable(7);
        assertTrue(hashTable.put(51, "Fifty One"));
        assertTrue(hashTable.put(54, "Fifty Four"));
        assertTrue(hashTable.put(7, "Seven"));
        assertTrue(hashTable.put(14, "Fourteen"));
        assertTrue(hashTable.put(21, "Twenty One"));
        assertTrue(hashTable.put(23, "Twenty Three"));
        // Put key 18
        assertTrue(hashTable.put(18, "Eighteen"));
        assertEquals("Eighteen", hashTable.get(18).value);
        // Remove key 18
        assertEquals("Eighteen", hashTable.remove(18).value);
        assertNull(hashTable.get(18));
        // Put key 18
        assertTrue(hashTable.put(18, "Eighteen"));
        assertEquals("Eighteen", hashTable.get(18).value);
    }
}