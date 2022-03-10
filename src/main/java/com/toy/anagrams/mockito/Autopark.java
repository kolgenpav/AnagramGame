package com.toy.anagrams.mockito;

import java.util.HashSet;
import java.util.Set;

public class Autopark {

    private Set<Car> cars;

    public Autopark() {
        this.cars = new HashSet<>();
    }

    void add(Car car){
        cars.add(car);
    }

    public Set<Car> getCars() {
        return cars;
    }

    void assignRoute(Car car, String destination, String cargo){
        car.driveTo(destination);
    }
}
