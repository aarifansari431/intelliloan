package com.intelliloan.loan.dto.response;

import com.intelliloan.loan.domain.enums.LoanStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LoanResponse {
    private Long id;
    private String applicantName;
    private BigDecimal loanAmount;
    private Integer tenureMonths;
    private BigDecimal interestRate;
    private String purpose;
    private LoanStatus status;
    private BigDecimal monthlyIncome;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String reviewNotes;
}