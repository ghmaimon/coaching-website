package com.coaching.backend.exception;

public class OfferNotFoundException extends OfferException{

    public OfferNotFoundException(String code, String message) {
        super(code, message);
    }

    public OfferNotFoundException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public OfferNotFoundException(String code, Exception exception) {
        super(code, exception);
    }

    public OfferNotFoundException(Exception exception) {
        super(exception);
    }

    public OfferNotFoundException(long id) {
        super(OfferNotFoundException.class.getSimpleName(),"the offer : "+id+" does not exist");
    }
}
