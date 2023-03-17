package com.toy.anagrams.integrationtest;

public class Two {
    private One one;

    public Two(One one) {
        this.one = one;
    }

    /*There is TwoTest - integration test*/
    public String resume() {
        return one.getText() + "_" + one.calc();
    }
}
