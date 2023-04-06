package com.toy.anagrams.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.verify;

/**
 * Spy creates the new Autopark object.
 */
@ExtendWith(MockitoExtension.class)
class SpyAutoparkTest {

    /*Spy is "live" class, it configured method will return value nedded,
     * other will work as confitional class*/

//    private Autopark autopark = spy(new Autopark());
    @Spy
    private Autopark autopark;

    @Mock
    private Car car;

    @Test
    void testAssignRoute() {
        autopark.add(car);
        assertEquals(1, autopark.getCars().size());

        /*We can configure Spy as Mock*/
        Mockito.when(autopark.toString()).thenReturn("Artificial autopark toString");
        System.out.println(autopark);;

        autopark.assignRoute(car, "Sweet home Alabama", "wheet");
        /*The method invoked from real object*/
        verify(car).driveTo("Sweet home Alabama");
        /*We can call real method from spy or real method, which wsa reconfigured for mock*/
        Mockito.doCallRealMethod().when(autopark).assignRoute(car, "","");
        autopark.assignRoute(car,"","");
    }
}