package com.toy.anagrams.mockito;

/**
 * Example of System Under Test for Test Doubles using.
 */
public interface Car {

    boolean needsFuel();

    double getEngineTemperature();

    String getModel();

    void driveTo(String destination);

    double getEngineVolume(String type);
}
