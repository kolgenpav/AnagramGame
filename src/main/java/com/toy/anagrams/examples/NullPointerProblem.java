package com.toy.anagrams.examples;

import java.util.HashSet;
import java.util.Set;

/**
 * NP problem for SpotBugs detection.
 */
public final class NullPointerProblem {

    private NullPointerProblem() {
    }

    /**
     * Entry point.
     * @param args
     */
    public static void main(final String[] args) {
        Set<Person> persons = new HashSet<>();
        for (Person p:persons) {
            if (p != null) {
                System.out.println(p.getName());
            }
            System.out.println(p.getName() + " не знайдено");
        }
    }

    static class Person {
        private String name;

        Person(final String aname) {
            this.name = aname;
        }

        public String getName() {
            return name;
        }
    }
}
