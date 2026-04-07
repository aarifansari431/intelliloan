package com.intelliloan.loan.service.impl;

import com.intelliloan.common.exception.ResourceNotFoundException;
import com.intelliloan.loan.domain.entity.Loan;
import com.intelliloan.loan.domain.enums.LoanStatus;
import com.intelliloan.loan.dto.request.LoanApplicationRequest;
import com.intelliloan.loan.dto.response.LoanResponse;
import com.intelliloan.loan.mapper.LoanMapper;
import com.intelliloan.loan.repository.LoanRepository;
import com.intelliloan.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor  // Lombok generates constructor injection
@Slf4j                    // Lombok generates log field
@Transactional(readOnly = true) // default read-only, override for writes
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    @Override
    @Transactional  // overrides readOnly=true for write operation
    public LoanResponse applyForLoan(LoanApplicationRequest request,
                                     Long applicantId) {
        log.info("Processing loan application for applicant: {}", applicantId);

        Loan loan = loanMapper.toEntity(request);
        loan.setApplicantId(applicantId);
        loan.setStatus(LoanStatus.SUBMITTED);

        Loan savedLoan = loanRepository.save(loan);

        log.info("Loan application created with id: {}", savedLoan.getId());
        return loanMapper.toResponse(savedLoan);
    }

    @Override
    public LoanResponse getLoanById(Long id) {
        log.debug("Fetching loan with id: {}", id);

        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", id));

        return loanMapper.toResponse(loan);
    }

    @Override
    public List<LoanResponse> getLoansByApplicant(Long applicantId) {
        return loanRepository.findByApplicantId(applicantId)
                .stream()
                .map(loanMapper::toResponse)
                .toList();
    }

    @Override
    public List<LoanResponse> getAllLoans() {
        return loanRepository.findAll()
                .stream()
                .map(loanMapper::toResponse)
                .toList();
    }
}