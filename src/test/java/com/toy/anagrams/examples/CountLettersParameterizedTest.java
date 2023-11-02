package com.toy.anagrams.examples;

import com.toy.anagrams.examples.CountLetters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

//@Disabled
class CountLettersParameterizedTest {

    @DisplayName("Parameterized test of int count(String str) method with CSVSource")
    @ParameterizedTest
    @CsvSource({
            "r|, 1",
            "s|, 1",
            "a|, 0",
            "s, 1"
//            "r, 1"
    })
    void countCSVSource(String word, int count) {
        int words = new CountLetters().count(word);
        Assertions.assertEquals(count, words);
    }

    @DisplayName("Parameterized test of int count(String str) method with CSVFileSource")
    @ParameterizedTest
    @CsvFileSource(resources = "/params.csv", numLinesToSkip = 1)  //csv file have to located in resources folder
    void countCSVFileSource(String word, int count) {
        int words = new CountLetters().count(word);
        Assertions.assertEquals(count, words);
    }

    @DisplayName("Parameterized test of int count(String str) method with MethodSource")
    @ParameterizedTest
    @MethodSource("paramsProvider")
    void countMethodSource(String word, int count) {
        int words = new CountLetters().count(word);
        Assertions.assertEquals(count, words);
    }

    static Stream<Arguments> paramsProvider() {
        return Stream.of(arguments("r|", 1),
                arguments("s|", 1),
                arguments("a|", 0),
                arguments("s", 1),
                arguments("r", 1));
    }
}