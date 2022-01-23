package com.coaching.backend.enumeration;

public enum SuperUserAuthorities {
    VIEW_USERS("view_users"),
    DELETE_USERS("delete_users"),
    CREATE_EVENTS("create_events")
    // just examples, to complete later
    ;
    private String value;

    SuperUserAuthorities(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
