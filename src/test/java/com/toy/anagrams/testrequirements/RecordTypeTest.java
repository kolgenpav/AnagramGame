package com.toy.anagrams.testrequirements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

//@Disabled
class RecordTypeTest {

    RecordType myRecord;

    @BeforeEach
    void setUp() {
        myRecord = new RecordType();
    }

    @Disabled
    @Test
    void checkEmptyInit() {
        assertTrue(myRecord.isEmpty());
        assertEquals(0, myRecord.getCrc());
    }

    @Disabled
    @ParameterizedTest(name = "{index} ==> for message=\"{0}\" checksum is {1} and empty is {2}")
    @CsvSource({
            "'Hello World!', 472456355, false",
            "'', 0, true",
            "'Hello World!123', 4155721158, false"
    })
    void testSetRecordCrc(String message, long checksum, boolean empty) {
        /*Перевіряється незалежність від початкового значення*/
        myRecord.setCrc(12345);
        myRecord.setMessage(message);
        RecordUtil.setRecordCrc(myRecord);
        assertEquals(checksum, myRecord.getCrc());
        assertEquals(empty, myRecord.isEmpty());
    }

    @Disabled
    @ParameterizedTest(name = "{index} ==> for message=\"{0}\" checksum is {1}, isCorrect is {2} and empty is {3}")
    @CsvSource({
            "'Hello World!', 472456355, true, false",
            "'Hello World!', 12345, false, false"
    })
    void testCheckRecordCrc(String message, long checksum, boolean isCorrect, boolean empty) {
        myRecord.setMessage(message);
        myRecord.setCrc(checksum);
        myRecord.setEmpty(empty);
        assertEquals(isCorrect, RecordUtil.checkRecordCrc(myRecord));
        assertEquals(empty, myRecord.isEmpty());
    }

    @Disabled
    @Test
    void testExceedLengthMessageSetRecordCrc() {
        Exception exception = assertThrowsExactly(IllegalArgumentException.class, () ->
                myRecord.setMessage("Hello World!Hello World!"));
        assertEquals("Message length exceeds 15 chars", exception.getMessage());
    }

    @Disabled
    @Test
    void testNullMessageSetRecordCrc() {
        Exception exception = assertThrowsExactly(IllegalArgumentException.class, () ->
                RecordUtil.setRecordCrc(myRecord));
        assertEquals("Message is null", exception.getMessage());
    }

    @Disabled
    @RepeatedTest(3)
    void testRepeatedSetRecordCrc() {
        myRecord.setMessage("Hello World!");
        RecordUtil.setRecordCrc(myRecord);
        long expResult = 472456355;
        assertEquals(expResult, myRecord.getCrc());
        assertFalse(myRecord.isEmpty());
    }

    @Disabled
    @Test
    void testReInitSetRecordCrc() {
        myRecord.setMessage("Hello World!");
        /* Повторна ініціалізація */
        myRecord = new RecordType();
        myRecord.setMessage("Hello World!");
        RecordUtil.setRecordCrc(myRecord);
        long expResult = 472456355;
        assertEquals(expResult, myRecord.getCrc());
        assertFalse(myRecord.isEmpty());
    }

    @Disabled
    @Test
    void testStabilityWithTimeout() {
        myRecord.setMessage("Hello World!");
        for (int i = 0; i < 10000; i++) {
            assertTimeout(Duration.ofMillis(100), () ->
                    RecordUtil.setRecordCrc(myRecord));
        }
    }
}