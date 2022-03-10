package com.toy.anagrams.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StubbingCarTest {

    @Mock
    private Car myFerrari;

    @Test
    public void testBooleanReturnStubbing() {
        /* Змінюємо значення за замовчуванням false, що повертається методом, на true */
        when(myFerrari.needsFuel()).thenReturn(true);
        /* Виконуємо перевірку зміненого значення, що повертається */
        assertTrue(myFerrari.needsFuel(), "Test double should return true");
    }

    @Test
    public void testDoubleReturnStubbing() {
        assertEquals(0.0, myFerrari.getEngineTemperature(), 0.0,
                "Test double should return 0.0 as double");
        /* Змінюємо значення за замовчуванням, що повертається методом, на 50.0*/
        when(myFerrari.getEngineTemperature()).thenReturn(50.0);
        /*Виконуємо перевірку зміненого значення, що повертається */
        assertEquals(50.0, myFerrari.getEngineTemperature(), 0.0,
                "Test double should return 50.0");
    }

    @Test
    public void testStringReturnStubbing() {
        assertNull(myFerrari.getModel(), "Test double should return null");
        /* Змінюємо значення за замовчуванням, що повертається методом, на "Ferrari" */
        when(myFerrari.getModel()).thenReturn("Ferrari");
        /* Виконуємо перевірку зміненого значення, що повертається */
        assertEquals("Ferrari", myFerrari.getModel(), "Test double should return \"Ferrari\"");
    }

    @Test
    public void testMultipleReturnStubbing() {
        String[] models = {"Ferrari", "Porche", "Mersedes"};
        when(myFerrari.getModel()).thenReturn("Ferrari", "Porche", "Mersedes");
        for (int i = 0; i < 3; i++) {
            /* Послідовні виклики методу будуть повертати послідовні елементи масиву*/
            assertEquals(models[i], myFerrari.getModel(), "Test double should return array items");
        }
        /* Подальші виклики методу повертатимуть останній елемент масиву */
        assertEquals("Mersedes", myFerrari.getModel(), "Test double should return the last item");
    }

    @Test
    public void testInputConditionalReturnStubbing() {
        assertEquals(0.0, myFerrari.getEngineVolume("ABC"), 0.0,
                "Test double should return 0.0");
        /* Змінюємо значення, що повертається методом, на різні величини залежно від
           аргумента методу */
        when(myFerrari.getEngineVolume("ABC")).thenReturn(3.5);
        when(myFerrari.getEngineVolume("DEF")).thenReturn(4.0);
        /* Виконуємо перевірку зміненого значення, що повертається */
        assertEquals(3.5, myFerrari.getEngineVolume("ABC"), 0.0,
                "Test double should return 3.5");
        assertEquals(4.0, myFerrari.getEngineVolume("DEF"), 0.0,
                "Test double should return 4.0");
    }

    @Test
    public void testBaseOnInputIndependentValueReturnStubbing() {
        /* Змінюємо значення, що повертається методом, на 3.0
           у разі введення будь-якого аргумента-рядка */
        when(myFerrari.getEngineVolume(anyString())).thenReturn(3.0);
        /* Перевіряємо значення, що повертається */
        assertEquals(3.0, myFerrari.getEngineVolume("QWERTY"), 0.0,
                "Test double should return 3.0");
    }

    @Test
    public void testBasedOnInputTypeReturnStubbing() {
        /* Змінюємо значення, що повертається методом, на 3.0
           у разі введення будь-якого аргумента-екземпляра класу String */
        when(myFerrari.getEngineVolume(isA(String.class))).thenReturn(3.0);
        /* Перевіряємо значення, що повертається */
        assertEquals(3.0, myFerrari.getEngineVolume("1wqaz"), 0.0,
                "Test double should return 3.0");
    }
}
