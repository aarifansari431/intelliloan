package com.intelliloan.loan.mapper;

import com.intelliloan.loan.domain.entity.Loan;
import com.intelliloan.loan.dto.request.LoanApplicationRequest;
import com.intelliloan.loan.dto.response.LoanResponse;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",  // makes it a Spring bean
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface LoanMapper {

    // Request → Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "reviewedBy", ignore = true)
    @Mapping(target = "reviewNotes", ignore = true)
    @Mapping(target = "interestRate", ignore = true)
    @Mapping(target = "creditScore", ignore = true)
    @Mapping(target = "applicantId", ignore = true)
    @Mapping(target = "status", ignore = true)
    Loan toEntity(LoanApplicationRequest request);

    // Entity → Response
    LoanResponse toResponse(Loan loan);
}