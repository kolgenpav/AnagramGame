package com.toy.anagrams.integrationtest.stub;

/*Stub should not contain any fields. Return methods should return some constants.
* Void method should be empty.*/
public class StubOne extends One {

    public StubOne() {
    }

    @Override
    public int calc() {
        return 0;
    }

    @Override
    public String getText() {
        return "Stub";
    }

    @Override
    public void setText(String text) {
    }
}

