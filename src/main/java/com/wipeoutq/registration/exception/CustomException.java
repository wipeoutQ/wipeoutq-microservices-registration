package com.wipeoutq.registration.exception;

public class CustomException extends RuntimeException{

    private final ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public CustomException(ErrorCode errorCode) {

        super(String.valueOf(errorCode));

        this.errorCode = errorCode;
    }
}
