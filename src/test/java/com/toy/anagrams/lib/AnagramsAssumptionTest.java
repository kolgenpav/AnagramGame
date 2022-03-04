package com.toy.anagrams.lib;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class AnagramsAssumptionTest {

    AbstractWordLibrary library = AbstractWordLibrary.getDefault();

    @DisplayName("Checks the isCorrect method timeout only after checking the method works")
    @Test
    void trueAssumption() {
        assumeTrue(library.isCorrect(0, "abstraction"), "Method isCorrect works wrong!");
        assertTimeout(Duration.ofMillis(300), () ->
                library.isCorrect(0, "abstraction"));
    }
}