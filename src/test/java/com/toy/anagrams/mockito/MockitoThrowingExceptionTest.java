package com.toy.anagrams.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MockitoThrowingExceptionTest {

    @Mock
    private Car myFerrari;

    @Test
    public void throwException() {
        /* Конфігуруємо метод на генерування виключення */
        when(myFerrari.needsFuel()).thenThrow(new RuntimeException("needsFuel Exception"));
        /* Перевіряємо виникнення виключення */
        RuntimeException assertNeedsFuelThrows = assertThrows(RuntimeException.class,
                () -> myFerrari.needsFuel());
        Assertions.assertEquals("needsFuel Exception",
                assertNeedsFuelThrows.getMessage());
        /* Також можливо сконфігурувати void метод на генерування виключення */
        doThrow(new IllegalArgumentException("Bad argument"))
                .when(myFerrari).driveTo("abc");
        IllegalArgumentException assertDriveToThrows =
                assertThrows(IllegalArgumentException.class,
                        () -> myFerrari.driveTo("abc"));
        Assertions.assertEquals("Bad argument",
                assertDriveToThrows.getMessage());
    }
}