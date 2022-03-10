package com.toy.anagrams.mockito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class TestDoubleCreateTest {

    private final Car myFerrari = mock(Car.class);

    @Test
    public void testIsACarAndDefaultValues() {
        /* Перевірка, чи є тестовий дублікат екземпляром
          класу, що реалізує інтерфейс Car*/
        assertTrue(myFerrari instanceof Car);
       /*Перевірка значень за замовчуванням методів тестового
         дубліката*/
        assertFalse(myFerrari.needsFuel(), "Test double should return false");
        assertEquals(0.0, myFerrari.getEngineTemperature(), 0.0,
                "Test double should return 0.0");
        assertNull(myFerrari.getModel(), "Test double should return null");
    }
}