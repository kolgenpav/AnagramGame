package com.toy.anagrams.lib;


public interface AbstractWordLibrary {

    /**
     * Get StaticWordLibrary object with words and scrambled words arrays.
     *
     * @return StaticWordLibrary instance
     */
    static AbstractWordLibrary getDefault() {
        return StaticWordLibrary.DEFAULT;
    }

    /**
     * Get word by array index.
     *
     * @param idx array index
     * @return initial word
     */
    String getWord(int idx);

    /**
     * Get scrambled word by array index.
     *
     * @param idx array index
     * @return scrambled word
     */
    String getScrambledWord(int idx);

    /**
     * Get arrays size.
     *
     * @return array size
     */
    int getSize();

    /**
     * Check if user choice is correct.
     *
     * @param idx       array index
     * @param userGuess user entered word
     * @return if the correct answer
     */
    boolean isCorrect(int idx, String userGuess);
}
