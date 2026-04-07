package com.intelliloan.common.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends IntelliLoanException {

    public BusinessException(String message, String errorCode) {
        super(message, errorCode, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}