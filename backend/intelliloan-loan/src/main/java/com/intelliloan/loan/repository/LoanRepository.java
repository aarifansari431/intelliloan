package com.intelliloan.loan.repository;

import com.intelliloan.loan.domain.entity.Loan;
import com.intelliloan.loan.domain.enums.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    // Spring Data generates SQL from method name
    List<Loan> findByApplicantId(Long applicantId);

    List<Loan> findByStatus(LoanStatus status);

    // Custom JPQL query — when method name gets too complex
    @Query("SELECT l FROM Loan l WHERE l.applicantId = :applicantId " +
            "AND l.status = :status ORDER BY l.createdAt DESC")
    List<Loan> findByApplicantIdAndStatus(
            @Param("applicantId") Long applicantId,
            @Param("status") LoanStatus status
    );

    // Count for dashboard metrics
    Long countByStatus(LoanStatus status);
}