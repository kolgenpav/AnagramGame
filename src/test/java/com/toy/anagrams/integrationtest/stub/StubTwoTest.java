package com.toy.anagrams.integrationtest.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StubTwoTest {

    @Test
    void testResume() {
        /*Stubbing One functionality*/
        IOne one = new StubOne();
        /*Stub has empty set method, so parameter does not matter*/
        one.setText("Unit Test");
        /*Stub injecting*/
        Two two = new Two(one);
        String expected = "Stub_0";
        String actual = two.resume();
        Assertions.assertEquals(expected,actual);
    }
}