package com.anuj.library_management.service;

import com.anuj.library_management.domain.entity.Loan;

import java.util.UUID;

public interface LoanService {
    Loan borrowBook(UUID bookId,UUID memberId);
}
