package com.anuj.library_management.controller;

import com.anuj.library_management.domain.entity.Loan;
import com.anuj.library_management.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/loans/borrow")
public class LoanController {
    final private LoanService loanService;
    public LoanController(LoanService loanService){
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<Loan> borrowBook(UUID bookuuid,UUID memberuuid){
        Loan loan = loanService.borrowBook(bookuuid,memberuuid);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }

}
