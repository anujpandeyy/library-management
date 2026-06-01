package com.anuj.library_management.service.impl;

import com.anuj.library_management.domain.entity.Book;
import com.anuj.library_management.domain.entity.Loan;
import com.anuj.library_management.domain.entity.Member;
import com.anuj.library_management.exception.BookNotAvailableException;
import com.anuj.library_management.exception.BookNotFoundException;
import com.anuj.library_management.exception.MemberNotFoundException;
import com.anuj.library_management.repository.BookRepository;
import com.anuj.library_management.repository.LoanRepository;
import com.anuj.library_management.repository.MemberRepository;
import com.anuj.library_management.service.LoanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class LoanServiceImpl implements LoanService {

    public final MemberRepository memberRepository;

    public final BookRepository bookRepository;

    public final LoanRepository loanRepository;

    public LoanServiceImpl(MemberRepository memberRepository,BookRepository bookRepository,LoanRepository loanRepository){
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
    }

    @Transactional
    @Override
    public Loan borrowBook(UUID bookId,UUID memberId){
        //check book
        Book book = bookRepository.findById(bookId).orElseThrow(()->new BookNotFoundException(bookId));
        //check member
        Member member = memberRepository.findById(memberId).orElseThrow(()->new MemberNotFoundException(memberId));

        if(!book.isAvailable()){
            throw new BookNotAvailableException(bookId);
        }

        Loan loan = new Loan(book,member,LocalDate.now(),LocalDate.now().plusDays(6));

        book.setAvailable(false); //set in Book like this not available
        bookRepository.save(book); //save the current state

        return loanRepository.save(loan);

    }
}
