package com.coaching.backend.enumeration;

public enum Role {

    CLIENT("ROLE_CLIENT"),
    COACH("ROLE_COACH"),
    SUPERUSER("ROLE_SUPERUSER");

    private String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
