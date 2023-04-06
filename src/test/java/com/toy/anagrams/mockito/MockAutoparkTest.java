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

    /*Mock is artificial class, only configured method will return value,
    * other return null*/
    private Autopark autopark = mock(Autopark.class);
//    @Mock
//    Autopark autopark;

    @Mock
    private Car car;

    @Test
    void testAssignRoute() {
        /*Invoke method that will be verified*/
        car.driveTo("Sweet home Alabama");
        autopark.add(car);
        /* For Mock autopark */
        assertEquals(0, autopark.getCars().size());

        autopark.assignRoute(car, "Sweet home Alabama", "wheet");
        verify(car).driveTo("Sweet home Alabama");
    }
}