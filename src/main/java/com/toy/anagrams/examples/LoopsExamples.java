package com.toy.anagrams.examples;

public class LoopsExamples {

    public int forLoop(int bound) {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (i == bound) {
                break;
            }
            result++;
        }
        return result;
    }
}
