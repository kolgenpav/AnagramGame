package com.toy.anagrams.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {

    @Test
    @DisplayName("boolean check(final int awordIdx, final String aguessedWordText) test with awordIdx = 0 " +
            "and aguessedWordText = abstraction")
    void check() {
        Anagrams anagrams = new Anagrams();
//        int awordIdx = 0;
        int awordIdx = 1;
        String aguessedWordText = "abstraction";
//        assertTrue(anagrams.check(awordIdx, aguessedWordText));
        assertFalse(anagrams.check(awordIdx, aguessedWordText));
    }
}