package com.anuj.library_management.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Loan")
public class Loan {
    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", book=" + book +
                ", member=" + member +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Loan(){

    }

    public Loan(UUID id, Book book, Member member, LocalDate borrowDate, LocalDate dueDate) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "loan_id",nullable = false,updatable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;
    @ManyToOne
    @JoinColumn(name="member_id",nullable = false)
    private Member member;
    @Column(name="borrow_date",nullable = false)
    private LocalDate borrowDate;
    @Column(name = "due_date",nullable = false)
    private LocalDate dueDate;
}
