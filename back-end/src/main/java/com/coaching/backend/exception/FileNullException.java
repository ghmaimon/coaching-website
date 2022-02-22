package com.coaching.backend.exception;

public class FileNullException extends UserException {
    public FileNullException() {
        super(FileNullException.class.getSimpleName(), "the file uploaded is null");
    }
}
