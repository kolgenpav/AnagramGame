package com.toy.anagrams.ui;

import com.toy.anagrams.lib.AbstractWordLibrary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.JLabel;
import javax.swing.JTextField;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MockitoAnagramsTest {

    /* Тестові дублікати для колабораторів */
    @Mock
    private AbstractWordLibrary wordLibrary;  //заглушка
    @Spy
    private JLabel feedbackLabel;             //шпигун
    @Spy
    private JTextField guessedWord;           //шпигун

    @Test
    void testCheck() {
        /* Конфігурування методу заглушки */
        when(wordLibrary.isCorrect(0, "abstraction")).thenReturn(true);
        /* Створення об`єкту системи, що тестується (SUT) */
        Anagrams anagrams = new Anagrams(wordLibrary, feedbackLabel, guessedWord);
        /* Тестування методу SUT */
        assertTrue(anagrams.check(0, "abstraction"));
        /* Верифікація виклику методу тестового дублікату*/
        verify(feedbackLabel).setText("Correct! Try a new word!");
        /* Тестування методу SUT */
        assertFalse(anagrams.check(0, "qwerty"));
        /* Верифікація виклику методу тестового дублікату*/
        verify(guessedWord).setText("");
    }
}