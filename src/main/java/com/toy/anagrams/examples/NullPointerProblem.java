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
     *
     * @param args command line args don't used
     */
    public static void main(final String[] args) {
        Set<Person> persons = new HashSet<>();
        persons.add(new Person("John"));
        for (Person p : persons) {
            /*SpotBugs will report about excessive null check.
              because the loop will not be executed if the set is empty. */
//            if (p != null) {
//                System.out.println(p.getName());
//            }
            /*SpotBugs will report about possible null pointer exception. */
//            System.out.println(p.getName()  + " не знайдено");
            System.out.println((p != null ? p.getName() : "Person") + " не знайдено");
        }

        double a = 1000.0000000000001;
        System.out.println(a);
    }

    static class Person {
        private final String name;

        Person(final String aname) {
            this.name = aname;
        }

        public String getName() {
            return name;
        }
    }
}
