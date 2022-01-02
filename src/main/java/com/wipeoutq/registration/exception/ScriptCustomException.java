package com.wipeoutq.registration.exception;

public class ScriptCustomException extends CustomException{

    private final String customCode;

    public String getCustomCode() {
        return this.customCode;
    }

    public ScriptCustomException(String customErrorCode) {

        super(ErrorCode.SCRIPT_CUSTOM_ERROR);

        this.customCode = customErrorCode;
    }
}
