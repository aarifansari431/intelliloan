CREATE SEQUENCE LOAN_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE LOANS (
    id              NUMBER PRIMARY KEY,
    applicant_id    NUMBER NOT NULL,
    applicant_name  VARCHAR2(100) NOT NULL,
    loan_amount     NUMBER(15,2) NOT NULL,
    tenure_months   NUMBER NOT NULL,
    interest_rate   NUMBER(5,2),
    purpose         VARCHAR2(500),
    status          VARCHAR2(20) NOT NULL,
    credit_score    NUMBER,
    monthly_income  NUMBER(15,2),
    reviewed_by     NUMBER,
    review_notes    VARCHAR2(1000),
    created_at      TIMESTAMP NOT NULL,
    updated_at      TIMESTAMP
);

-- Indexes
CREATE INDEX idx_loans_status ON LOANS(status);
CREATE INDEX idx_loans_applicant ON LOANS(applicant_id);
CREATE INDEX idx_loans_status_created ON LOANS(status, created_at);