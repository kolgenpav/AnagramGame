package com.toy.anagrams.lib;

/**
 *
 */
public abstract class AbstractWordLibrary {

    protected AbstractWordLibrary() {
    }

    public static AbstractWordLibrary getDefault() {
        return StaticWordLibrary.DEFAULT;
    }

    public abstract String getWord(int idx);


    public abstract String getScrambledWord(int idx);


    public abstract int getSize();

    public abstract boolean isCorrect(int idx, String userGuess);
}
