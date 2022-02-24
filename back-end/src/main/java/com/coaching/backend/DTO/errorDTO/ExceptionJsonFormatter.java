package com.coaching.backend.DTO.errorDTO;


import com.coaching.backend.exception.GeneralException;

public record ExceptionJsonFormatter(String code, String message) {
    public static ExceptionJsonFormatter convertExceptionToJson(GeneralException exception) {
        return new ExceptionJsonFormatter(exception.getCode(), exception.getMessage());
    }
}
