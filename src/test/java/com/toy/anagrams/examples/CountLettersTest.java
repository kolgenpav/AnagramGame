package com.toy.anagrams.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class CountLettersTest {

    @Test
    void count() {
        int words = new CountLetters().count("r|s|a|s");
        Assertions.assertEquals(3, words);
    }
}