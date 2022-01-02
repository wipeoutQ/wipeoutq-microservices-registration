package com.wipeoutq.registration.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wipeoutq.registration.exception.CustomException;
import com.wipeoutq.registration.exception.ErrorCode;
import com.wipeoutq.registration.exception.ScriptCustomException;

import java.util.Date;

public class Response {
    public Response() {
        this.timestamp = new Date();
    }

    public Response(Throwable exception) {
        this();
        this.fail();

        String errorCodeString = ErrorCode.UNKNOWN.code();

        if (exception instanceof ScriptCustomException) {
            ScriptCustomException ex = (ScriptCustomException) exception;
            ErrorCode errorCode = ex.getErrorCode();
            String customErrorCode = ex.getCustomCode();

            errorCodeString = errorCode.code(customErrorCode);
        }
        else if (exception instanceof CustomException) {

            CustomException ex = (CustomException) exception;
            ErrorCode errorCode = ex.getErrorCode();

            errorCodeString = errorCode.code();
        }

        this.setErrorCode(errorCodeString);
    }

    public Response(Throwable exception, String message) {
        this(exception);
        this.setMessage(message);
    }

    private Boolean success;

    private Object data;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss")
    private Date timestamp;

    // @JsonInclude(Include.NON_EMPTY)
    private String message;

    // @JsonInclude(Include.NON_EMPTY)
    private String errorCode;

    public Boolean getSuccess() {
        return this.success;
    }

    private void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    private void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void fail() {
        this.setSuccess(Boolean.FALSE);
    }

    public void succeed() {
        this.setSuccess(Boolean.TRUE);
    }
}
