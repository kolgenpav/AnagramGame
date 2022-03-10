package com.toy.anagrams.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MockAutoparkTest {

    private Autopark autopark = mock(Autopark.class);

    @Mock
    private Car car;

    @Test
    void testAssignRoute() {
        /* For Mock autopark */
        doNothing().when(car).driveTo("Sweet home Alabama");
        car.driveTo("Sweet home Alabama");
        autopark.add(car);
        /* For Mock autopark */
        assertEquals(0, autopark.getCars().size());

        autopark.assignRoute(car, "Sweet home Alabama", "wheet");
        verify(car).driveTo("Sweet home Alabama");
    }
}