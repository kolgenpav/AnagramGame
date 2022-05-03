package com.toy.anagrams.testrequirements;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.zip.CRC32;

public class RecordType {
    private String message;
    int number;
    private long crc;
    private boolean empty = true;

    public RecordType() {
        this.crc = 0;
    }

    /**
     * Обчислення контрольної суми.
     *
     * @param record запис, для якого обчислюється контрольна сума
     */
    public static void calculateAndSetCRC(RecordType record) {
        System.out.println("Розрахунок контрольної суми та встановлення значення crc");
        long checksumValue = getChecksumValue(record);
        record.setCrc(checksumValue);
        System.out.println("Встановлення значення empty");
        record.setEmpty(true);
        checkRecordNotEmpty(record);
    }

    /**
     * Перевірка контрольної суми.
     *
     * @param record запис, для якого перевіряється контрольна сума
     * @return true якщо контрольна сума правильна
     */
    public static boolean checkCRC(RecordType record) {
        System.out.println("Перевірка контрольної суми та встановлення значення isCorrect");
        long checksumValue = getChecksumValue(record);
        long crc = record.getCrc();
        boolean isCorrect = (crc == checksumValue) ? true : false;
        System.out.println("Встановлення значення empty");
        record.setEmpty(true);
        if (record.getCrc() != 0) {
            record.setEmpty(false);
        } else {
            checkRecordNotEmpty(record);
        }
        return isCorrect;
    }

    private static long getChecksumValue(RecordType record) {
        if (record.getMessage() == null) {
            throw new IllegalArgumentException("Message is null");
        }
        CRC32 crc = new CRC32();
        crc.update(record.getMessage().getBytes(StandardCharsets.UTF_8));
        long checksumValue = crc.getValue();
        return checksumValue;
    }

    private static void checkRecordNotEmpty(RecordType record) {
        if (record.getMessage() == null) {
            throw new IllegalArgumentException("Message is null");
        }
        for (byte b : record.getMessage().getBytes()) {
            if (b != 0) {
                record.setEmpty(false);
                break;
            }
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message.length() > 15) {
            throw new IllegalArgumentException("Message length exceeds 15 chars");
        }
        this.message = message;
    }

    public long getCrc() {
        return crc;
    }

    public void setCrc(long crc) {
        this.crc = crc;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
