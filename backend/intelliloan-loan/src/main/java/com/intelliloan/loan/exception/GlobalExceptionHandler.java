package com.intelliloan.loan.exception;

import com.intelliloan.common.exception.IntelliLoanException;
import com.intelliloan.common.response.ApiError;
import com.intelliloan.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // Handle our custom exceptions
    @ExceptionHandler(IntelliLoanException.class)
    public ResponseEntity<ApiResponse<Void>> handleIntelliLoanException(
            IntelliLoanException ex) {

        log.error("Business exception: {} - {}", ex.getErrorCode(), ex.getMessage());

        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(ApiResponse.error(ex.getMessage(), ex.getErrorCode()));
    }

    // Handle @Valid validation failures
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage,
                        (existing, replacement) -> existing
                ));

        log.warn("Validation failed: {}", fieldErrors);

        ApiError error = ApiError.builder()
                .code("VALIDATION_FAILED")
                .message("Request validation failed")
                .fieldErrors(fieldErrors)
                .build();

        return ResponseEntity
                .badRequest()
                .body(ApiResponse.<Void>builder()
                        .success(false)
                        .error(error)
                        .build());
    }

    // Catch-all for unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex) {
        log.error("Unexpected error occurred", ex);

        return ResponseEntity
                .internalServerError()
                .body(ApiResponse.error(
                        "An unexpected error occurred",
                        "INTERNAL_SERVER_ERROR"
                ));
    }
}