package com.intelliloan.loan.controller;

import com.intelliloan.common.response.ApiResponse;
import com.intelliloan.loan.dto.request.LoanApplicationRequest;
import com.intelliloan.loan.dto.response.LoanResponse;
import com.intelliloan.loan.service.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200") // allow shell to call this
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<ApiResponse<LoanResponse>> applyForLoan(
            @Valid @RequestBody LoanApplicationRequest request) {

        // Hardcoded applicantId=1L for now — Day 4 we get this from JWT
        LoanResponse response = loanService.applyForLoan(request, 1L);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Loan application submitted successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LoanResponse>> getLoan(
            @PathVariable Long id) {

        LoanResponse response = loanService.getLoanById(id);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<LoanResponse>>> getAllLoans() {
        List<LoanResponse> loans = loanService.getAllLoans();
        return ResponseEntity.ok(ApiResponse.success(loans));
    }
}