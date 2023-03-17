package com.toy.anagrams.integrationtest.stub;

public class One implements IOne {

    private String text;

    public One() {
    }

    @Override
    public int calc() {
        int result = 0;
        return result;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
