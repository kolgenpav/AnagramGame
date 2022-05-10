package com.toy.anagrams.examples;

public class CountLetters {

    /**
     * Counts words that end with r or s.
     *
     * @param str word to be parsed
     * @return number of words
     */
    public int count(final String str) {
        int words = 0;
        char last = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))
                    && (last == 'r' || last == 's')) {
                words++;
            }

            last = str.charAt(i);
        }

        if (last == 'r' || last == 's') {
            words++;
        }

        return words;
    }
}
