package com.toy.anagrams.testrequirements;

public class RecordType {
    public static final int MAX_LENGTH = 15;

    private String message;
    private long crc;
    private boolean empty;

    public RecordType() {
        this.empty = true;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message.length() > MAX_LENGTH) {
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
