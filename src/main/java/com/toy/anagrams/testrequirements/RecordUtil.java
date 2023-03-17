package com.toy.anagrams.testrequirements;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;

public final class RecordUtil {
    /**
     * Обчислення контрольної суми, встановлення її для запису
     * та встановлення поля empty.
     *
     * @param myRecord запис, для якого обчислюється контрольна сума
     */
    public static void setRecordCrc(RecordType myRecord) {
        System.out.println("Розрахунок та встановлення значення crc");
        long checksumValue = calculateCrc(myRecord);
        myRecord.setCrc(checksumValue);
        System.out.println("Розрахунок та встановлення значення empty");
        boolean empty = calculateRecordEmpty(myRecord);
        myRecord.setEmpty(empty);
    }

    /**
     * Перевірка контрольної суми запису та встановлення поля empty.
     *
     * @param myRecord запис, для якого перевіряється контрольна сума
     * @return true якщо контрольна сума правильна
     */
    public static boolean checkRecordCrc(RecordType myRecord) {
        System.out.println("Перевірка контрольної суми запису");
        long checksumValue = calculateCrc(myRecord);
        long crc = myRecord.getCrc();
        boolean isCorrect = crc == checksumValue;
        System.out.println("Розрахунок та встановлення значення empty");
        boolean empty = calculateRecordEmpty(myRecord);
        myRecord.setEmpty(empty);
        return isCorrect;
    }

    /**
     * Розрахунок контрольної суми CRC-32 для запису.
     *
     * @param myRecord запис, для якого перевіряється контрольна сума
     * @return контрольна сума
     */
    private static long calculateCrc(RecordType myRecord) {
        if (myRecord.getMessage() == null) {
            throw new IllegalArgumentException("Message is null");
        }
        CRC32 crc = new CRC32();
        crc.update(myRecord.getMessage().getBytes(StandardCharsets.UTF_8));
        return crc.getValue();
    }

    /**
     * Розраховує значення поля empty для запису.
     *
     * @param myRecord запис, для якого перевіряється контрольна сума
     * @return true якщо всі байти message дорівнюють 0
     */
    private static boolean calculateRecordEmpty(RecordType myRecord) {
        if (myRecord.getMessage() == null) {
            throw new IllegalArgumentException("Message is null");
        }
        boolean isEmpty = true;
        for (byte b : myRecord.getMessage().getBytes(StandardCharsets.UTF_8)) {
            if (b != 0) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }
}
