package com.coaching.backend.exception;

public class OfferException extends GeneralException{
    public OfferException(String code, String message) {
        super(code, message);
    }

    public OfferException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public OfferException(String code, Exception exception) {
        super(code, exception);
    }

    public OfferException(Exception exception) {
        super(exception);
    }
}
