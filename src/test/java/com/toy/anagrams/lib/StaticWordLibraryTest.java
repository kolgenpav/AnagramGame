package com.toy.anagrams.lib;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("StaticWordLibrary methods test")
public class StaticWordLibraryTest {

    AbstractWordLibrary library;

    @BeforeEach
    void setUp() {
        library = AbstractWordLibrary.getDefault();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("String getWord(int idx) test with idx=0")
    void getWord() {
        assertEquals("abstraction", library.getWord(0));
    }

    @Test
    @DisplayName("String getScrambledWord(int idx) test with idx=0")
    void getScrambledWord() {
        assertEquals("batsartcoin", library.getScrambledWord(0));
    }

    @Test
    @DisplayName("int getSize() for WORD_LIST array test")
    void getSize() {
        assertEquals(45, library.getSize());
    }

    @Test
    @DisplayName("boolean isCorrect(final int idx, final String userGuess) test with idx=0 and userGuess=\"abstraction\"")
    void isCorrect() {
        assertTrue(library.isCorrect(0, "abstraction"));
    }
}