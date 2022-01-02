package com.wipeoutq.registration.exception;

import org.springframework.util.StringUtils;

public enum ErrorCode {
        /**
         * Error-codes.
         */
        UNKNOWN,


        SCRIPT_CUSTOM_ERROR;

    private String servicePrefix = "UTILSRVC";

    public String code() {

        StringBuilder errorCode = new StringBuilder();
        // @formatter:off
        errorCode
                .append(this.servicePrefix)
                .append('.')
                .append(this);
        // @formatter:on
        return errorCode.toString();
    }

    public String code(String customCode) {

        StringBuilder errorCode = new StringBuilder();
        // @formatter:off
        errorCode
                .append(this.servicePrefix)
                .append('.')
                .append(this)
                .append('-')
                .append(StringUtils.capitalize(customCode));
        // @formatter:on
        return errorCode.toString();
    }
}
