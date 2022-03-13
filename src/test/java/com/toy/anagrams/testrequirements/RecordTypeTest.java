package com.toy.anagrams.testrequirements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecordTypeTest {

    RecordType record;

    @BeforeEach
    void setUp(){
        record = new RecordType();
    }

    @Test
    public void checkEmptyInit(){
        assertTrue(record.isEmpty());
    }

    @ParameterizedTest(name = "{index} ==> for message=\"{0}\" checksum is {1} and empty is {2}")
    @CsvSource({
            "'Hello World!', 472456355, false",
            "'', 0, true",
            "'Hello World!123', 4155721158, false"
    })
    public void testCalculateAndSetCRC(String message, long checksum, boolean isEmpty){
        /*Перевіряється незалежність від початкового значення*/
        record.setCrc(12345);
        record.setMessage(message);
        RecordType.calculateAndSetCRC(record);
        long expResult = checksum;
        assertEquals(expResult, record.getCrc());
        assertEquals(isEmpty, record.isEmpty());
    }

    @ParameterizedTest(name = "{index} ==> for message=\"{0}\" checksum is {1}, isCorrect is {2} and empty is {3}")
    @CsvSource({
            "'Hello World!', 472456355, true, false",
            "'Hello World!', 12345, false, false"
    })
    public void testCheckCRC(String message, long checksum, boolean isCorrect, boolean isEmpty){
        record.setMessage(message);
        record.setCrc(checksum);
        record.setEmpty(isEmpty);
        assertEquals(isCorrect, RecordType.checkCRC(record));
        assertEquals(isEmpty, record.isEmpty());
    }

    @Test
    void testNullMessageCalculateAndSetCRC() {
        Exception exception = assertThrowsExactly(IllegalArgumentException.class, () ->
                RecordType.calculateAndSetCRC(record));
        assertEquals("Message is null", exception.getMessage());
    }

    @RepeatedTest(3)
    public void testRepeateedCalculateAndSetCRC(){
            record.setMessage("Hello World!");
            RecordType.calculateAndSetCRC(record);
            long expResult = 472456355;
            assertEquals(expResult, record.getCrc());
            assertFalse(record.isEmpty());
    }

    @Test
    public void testReinitCalculateAndSetCRC(){
        record.setMessage("Hello World!");
        /* Повторна ініціалізація */
        record = new RecordType();
        record.setMessage("Hello World!");
        RecordType.calculateAndSetCRC(record);
        long expResult = 472456355;
        assertEquals(expResult, record.getCrc());
        assertFalse(record.isEmpty());
    }

    @Test
    void testStabilityWithTimeout() {
        record.setMessage("Hello World!");
        for (int i = 0; i < 10000; i++) {
            assertTimeout(Duration.ofMillis(120), () ->
                    RecordType.calculateAndSetCRC(record));
        }
    }
}