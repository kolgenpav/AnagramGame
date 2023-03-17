package com.toy.anagrams.integrationtest.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StubTwoTest {

    @Test
    void testResume() {
        IOne one = new StubOne();
        /*Stubbing One functionality*/
        one.setText("Unit Test");
        Two two = new Two(one);
        String expected = "Unit Test_0";
        String actual = two.resume();
        Assertions.assertEquals(expected,actual);
    }
}