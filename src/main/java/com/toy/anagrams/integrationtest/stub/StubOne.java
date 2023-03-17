package com.toy.anagrams.integrationtest.stub;

public class StubOne extends One {

    private String text;

    public StubOne() {
        super();
    }

    @Override
    public int calc() {
        return 0;
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

