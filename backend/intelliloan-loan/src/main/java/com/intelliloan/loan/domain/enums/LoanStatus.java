package com.intelliloan.loan.domain.enums;

public enum LoanStatus {
    DRAFT,          // saved but not submitted
    SUBMITTED,      // submitted for review
    UNDER_REVIEW,   // officer picked it up
    APPROVED,       // approved, pending disbursement
    REJECTED,       // rejected with reason
    DISBURSED,      // money sent to borrower
    CLOSED          // fully repaid
}
