package com.intelliloan.loan.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanApplicationRequest {

    @NotNull(message = "Loan amount is required")
    @DecimalMin(value = "10000.00", message = "Minimum loan amount is 10,000")
    @DecimalMax(value = "10000000.00", message = "Maximum loan amount is 1,00,00,000")
    private BigDecimal loanAmount;

    @NotNull(message = "Tenure is required")
    @Min(value = 6, message = "Minimum tenure is 6 months")
    @Max(value = 360, message = "Maximum tenure is 360 months")
    private Integer tenureMonths;

    @NotBlank(message = "Purpose is required")
    @Size(max = 500, message = "Purpose cannot exceed 500 characters")
    private String purpose;

    @NotNull(message = "Monthly income is required")
    @DecimalMin(value = "0.01", message = "Monthly income must be positive")
    private BigDecimal monthlyIncome;

    @NotBlank(message = "Applicant name is required")
    @Size(max = 100)
    private String applicantName;
}