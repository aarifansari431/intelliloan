package com.intelliloan.loan.domain.entity;

import com.intelliloan.loan.domain.enums.LoanStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "LOANS",
        indexes = {
                // Index on status — most queries filter by status
                @Index(name = "idx_loans_status", columnList = "status"),
                // Index on applicant — borrower views their own loans
                @Index(name = "idx_loans_applicant", columnList = "applicant_id"),
                // Composite index — officer dashboard filters by status + created date
                @Index(name = "idx_loans_status_created", columnList = "status, created_at")
        }
)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "loan_seq")
    @SequenceGenerator(name = "loan_seq",
            sequenceName = "LOAN_SEQ",
            allocationSize = 1)
    private Long id;

    @Column(name = "applicant_id", nullable = false)
    private Long applicantId;

    @Column(name = "applicant_name", nullable = false, length = 100)
    private String applicantName;

    @Column(name = "loan_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal loanAmount;

    @Column(name = "tenure_months", nullable = false)
    private Integer tenureMonths;

    @Column(name = "interest_rate", precision = 5, scale = 2)
    private BigDecimal interestRate;

    @Column(name = "purpose", length = 500)
    private String purpose;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private LoanStatus status;

    @Column(name = "credit_score")
    private Integer creditScore;

    @Column(name = "monthly_income", precision = 15, scale = 2)
    private BigDecimal monthlyIncome;

    // Audit fields — auto populated by Spring Data JPA Auditing
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "reviewed_by")
    private Long reviewedBy;

    @Column(name = "review_notes", length = 1000)
    private String reviewNotes;
}