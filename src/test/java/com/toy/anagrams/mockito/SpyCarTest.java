package com.toy.anagrams.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SpyCarTest {

    @Spy
    private Car car;

    @Test
    public void testBehaviorVerification() {
        car.driveTo("Sweet home Alabama");
        car.needsFuel();
        car.needsFuel();
        /* Верифікація факту запуску методу driveTo з визначеним параметром */
        verify(car).driveTo("Sweet home Alabama");
        /* Можливі верифікації кількості викликів методів */
        verify(car, times(2)).needsFuel();
        verify(car, never()).getModel();
        verify(car, atLeastOnce()).driveTo("Sweet home Alabama");
        verify(car, atLeast(2)).needsFuel();
        verify(car, atMost(2)).needsFuel();
    }
}
