package com.coaching.backend.exception;

public class CoachNotFoundException extends UserNotFoundException{
    public CoachNotFoundException(long id) {
        super("Coach",id);
    }
    public CoachNotFoundException(String email) {
        super("Coach",email);
    }
}
