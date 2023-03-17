package com.toy.anagrams.integrationtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoTest {

    @Test
    void resumeTest() {
        One one = new One();
        one.setText("Integration Test");
        Two two = new Two(one);
        String expected = "Integration Test_";
        String actual = two.resume();
        Assertions.assertEquals(expected, actual);
    }
}