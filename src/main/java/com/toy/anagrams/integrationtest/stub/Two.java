package com.toy.anagrams.integrationtest.stub;

public class Two {
    private IOne one;

    public Two(IOne one) {
        this.one = one;
    }

    public String resume() {
        return one.getText() + "_" + one.calc();
    }
}
