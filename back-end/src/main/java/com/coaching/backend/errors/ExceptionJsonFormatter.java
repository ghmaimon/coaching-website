package com.coaching.backend.errors;


import com.coaching.backend.exception.GeneralException;
import com.coaching.backend.exception.UserException;

public record ExceptionJsonFormatter(String code, String message) {
    public static ExceptionJsonFormatter convertExceptionToJson(GeneralException exception) {
        return new ExceptionJsonFormatter(exception.getCode(), exception.getMessage());
    }
}
