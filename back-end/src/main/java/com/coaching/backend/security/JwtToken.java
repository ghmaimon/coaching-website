package com.coaching.backend.security;

public class JwtToken {

    private String Authorization;

    public JwtToken(String Authorization) {
        this.Authorization = Authorization;
    }

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String Authorization) {
        this.Authorization = Authorization;
    }
}
