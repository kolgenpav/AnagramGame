package com.toy.anagrams.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * Spy creates the new Autopark object.
 */
@ExtendWith(MockitoExtension.class)
class SpyAutoparkTest {

//    private Autopark autopark = spy(new Autopark());
    @Spy
    private Autopark autopark;

    @Mock
    private Car car;

    @Test
    void testAssignRoute() {
        autopark.add(car);
        assertEquals(1, autopark.getCars().size());

        autopark.assignRoute(car, "Sweet home Alabama", "wheet");
        /*The method invoked from real object*/
        verify(car).driveTo("Sweet home Alabama");
    }
}