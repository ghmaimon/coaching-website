package com.coaching.backend.enumeration;

public enum Level {
    BEGINNER("beginner"),
    INTERMEDIATE("intermediate"),
    EXPERT("expert");

    private String value;

    Level(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
