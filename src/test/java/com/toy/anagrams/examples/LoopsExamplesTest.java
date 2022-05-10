package com.toy.anagrams.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoopsExamplesTest {

    @Test
    void forLoop() {
        LoopsExamples instance = new LoopsExamples();
        int bound = 1;
        int expectedResult = 1;
        int result = instance.forLoop(bound);
        assertEquals(expectedResult,result);
    }
}