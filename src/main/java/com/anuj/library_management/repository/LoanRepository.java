package com.anuj.library_management.repository;

import com.anuj.library_management.domain.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanRepository extends JpaRepository<Loan,UUID> {
}
