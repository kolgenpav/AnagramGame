package com.toy.anagrams.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AnagramsTest {

    @DisplayName("Test of boolean check(final int awordIdx, final String aguessedWordText) method")
    @ParameterizedTest(name = "{index} ==> at Idx={0} word is {1} - that is {2}")
    @CsvSource({
            "0, abstraction, true",
            "1, 'abstraction', false"
    })
    public void check(int wordIdx, String guessedWordText, boolean expResult) {
        Anagrams anagrams = new Anagrams();
        boolean result = anagrams.check(wordIdx, guessedWordText);
        assertEquals(expResult, result);
    }

    @ParameterizedTest
    @MethodSource("stringIntAndStringProvider")
    public void checkWithArgsMethod(int wordIdx, String guessedWordText, boolean expResult) {
        Anagrams anagrams = new Anagrams();
        boolean result = anagrams.check(wordIdx, guessedWordText);
        assertEquals(expResult, result);
    }

    static Stream<Arguments> stringIntAndStringProvider() {
        return Stream.of(arguments(0, "abstraction", true),
                arguments(1, "abstraction", false));
    }
}