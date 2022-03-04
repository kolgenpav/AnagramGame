package com.toy.anagrams.lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("StaticWordLibrary method test with negative scenario")
public class UserGuessNegativeTest {

    AbstractWordLibrary library;

    @BeforeEach
    void setUp(){
        library = AbstractWordLibrary.getDefault();
    }

    @Test
    @DisplayName("isCorrect negative test for user input with digits")
    void isCorrect() {
        Exception exception = assertThrowsExactly(IllegalArgumentException.class, () ->
                library.isCorrect(0, "abstraction1"));
    }

//    @Disabled
    @Test
    @DisplayName("isCorrect negative test for method runtime exceeds 100 ms timeout")
    void isCorrectTimeout() {
        assertTimeout(Duration.ofMillis(120), () ->
                library.isCorrect(0, "abstraction"));
    }
}