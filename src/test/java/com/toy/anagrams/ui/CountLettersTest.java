package com.toy.anagrams.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//@Disabled
class CountLettersTest {

    @Test
    void count() {
        int words = new CountLetters().count("r|s|a|s");
        Assertions.assertEquals(3, words);
    }
}