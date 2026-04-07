// intelliloan-common/src/main/java/com/intelliloan/common/response/ApiError.java
package com.intelliloan.common.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class ApiError {
    private String code;
    private String message;
    private Map<String, String> fieldErrors; // for validation errors
}