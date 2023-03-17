package com.toy.anagrams.integrationtest;

public class Appl {
    public static void main(String[] args) {
        One one = new One();
        one.setText("data");
        Two two = new Two(one);
        two.resume();
    }
}
