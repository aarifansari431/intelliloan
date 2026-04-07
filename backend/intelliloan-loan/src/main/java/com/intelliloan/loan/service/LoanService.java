package com.intelliloan.loan.service;

import com.intelliloan.loan.dto.request.LoanApplicationRequest;
import com.intelliloan.loan.dto.response.LoanResponse;

import java.util.List;

public interface LoanService {
    LoanResponse applyForLoan(LoanApplicationRequest request, Long applicantId);
    LoanResponse getLoanById(Long id);
    List<LoanResponse> getLoansByApplicant(Long applicantId);
    List<LoanResponse> getAllLoans();
}