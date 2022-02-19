package com.coaching.backend.errors;


import com.coaching.backend.exception.UserException;

public record ExceptionJsonFormatter(String code, String message) {
    public static ExceptionJsonFormatter convertExceptionToJson(UserException exception) {
        return new ExceptionJsonFormatter(exception.getCode(), exception.getMessage());
    }
}
