package com.intelliloan.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // don't serialize null fields
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;
    private ApiError error;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    // Static factory methods — clean API for callers
    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> error(String message, String errorCode) {
        return ApiResponse.<T>builder()
                .success(false)
                .error(ApiError.builder()
                        .code(errorCode)
                        .message(message)
                        .build())
                .build();
    }
}