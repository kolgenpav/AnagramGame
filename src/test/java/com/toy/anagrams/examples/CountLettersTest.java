package com.toy.anagrams.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

//@Disabled
class CountLettersTest {

//    @Disabled
    @Test
    void count() {
        int words = new CountLetters().count("ar|s|sa|s");
        Assertions.assertEquals(3, words);
    }

    @Disabled
    @Test
    void count1() {
        int words = new CountLetters().count("ar|s|sa|r");
        Assertions.assertEquals(3, words);
    }
}