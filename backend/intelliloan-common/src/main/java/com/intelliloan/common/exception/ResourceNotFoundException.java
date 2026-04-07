package com.intelliloan.common.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends IntelliLoanException {

    public ResourceNotFoundException(String resourceName, Long id) {
        super(
                resourceName + " not found with id: " + id,
                resourceName.toUpperCase() + "_NOT_FOUND",
                HttpStatus.NOT_FOUND
        );
    }
}