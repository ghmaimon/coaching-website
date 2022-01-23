package com.coaching.backend.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(long id) {
        super("User not found with id : " + id);
    }

    public UserNotFoundException(String email) {
        super("User not found with email : " + email);
    }
}
