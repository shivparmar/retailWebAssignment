package com.nagarro.poc.retail.exception;

/**
 * @author Nagarro
 * @since January 23, 2020
 */
public class ApplicationException extends Exception {

    private String errorCode;
    private String errorMsg;
    public ApplicationException() {
        super();
    }

    public ApplicationException(String errorCode, String errorMsg) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
