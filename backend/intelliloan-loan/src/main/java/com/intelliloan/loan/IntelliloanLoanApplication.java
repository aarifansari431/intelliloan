package com.intelliloan.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IntelliloanLoanApplication {

	public static void main(String[] args) {

		SpringApplication.run(IntelliloanLoanApplication.class, args);
	}

}
