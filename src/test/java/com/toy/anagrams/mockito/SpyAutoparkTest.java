package com.toy.anagrams.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SpyAutoparkTest {

    private Autopark autopark = spy(new Autopark());

    @Mock
    private Car car;

    @Test
    void testAssignRoute() {
        autopark.add(car);
        /* For Spy autopark */
        assertEquals(1, autopark.getCars().size());

        autopark.assignRoute(car, "Sweet home Alabama", "wheet");
        verify(car).driveTo("Sweet home Alabama");
    }
}