package com.anuj.library_management.seeder;

import com.anuj.library_management.domain.entity.Author;
import com.anuj.library_management.domain.entity.Book;
import com.anuj.library_management.domain.entity.Loan;
import com.anuj.library_management.domain.entity.Member;
import com.anuj.library_management.domain.enums.MemberType;
import com.anuj.library_management.repository.AuthorRepository;
import com.anuj.library_management.repository.BookRepository;
import com.anuj.library_management.repository.LoanRepository;
import com.anuj.library_management.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DatabaseSeeder {
    @Bean
    public CommandLineRunner seedDatabase(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            LoanRepository loanRepository,
            MemberRepository memberRepository
    ){
        return args ->{
            //Authors
            Author a1 = new Author();
            a1.setName("George Orwell");
            a1.setDate_of_birth(java.util.Date.from(
                    LocalDate.of(1903, 6, 25)
                            .atStartOfDay(java.time.ZoneId.systemDefault())
                            .toInstant()));
            a1.setEmail("georgeorwell@gmail.com");
            authorRepository.save(a1);

            Author a2 = new Author();
            a2.setName("J.K. Rowling");
            a2.setDate_of_birth(java.util.Date.from(
                    LocalDate.of(1965, 7, 31)
                            .atStartOfDay(java.time.ZoneId.systemDefault())
                            .toInstant()));
            a2.setEmail("jkrowling@gmail.com");
            authorRepository.save(a2);

            //Books
            Book b1 = new Book();
            b1.setName("1984");
            b1.setISBN("978-0451524935");
            b1.setAuthor(a1);
            b1.setPublished(LocalDate.of(1949, 6, 8));
            b1.setPages(328);
            b1.setAvailable(true);
            bookRepository.save(b1);

            Book b2 = new Book();
            b2.setName("Harry Potter and the Sorcerer's Stone");
            b2.setISBN("978-0590353427");
            b2.setAuthor(a2);
            b2.setPublished(LocalDate.of(1997, 6, 26));
            b2.setPages(309);
            b2.setAvailable(true);
            bookRepository.save(b2);

            //Members
            Member m1 = new Member();
            m1.setName("Alice Doe");
            m1.setMembershipDate(LocalDate.of(2026,01,17));
            m1.setMemberType(MemberType.STUDENT);
            memberRepository.save(m1);

            Member m2 = new Member();
            m2.setName("Bob Smith");
            m2.setMembershipDate(LocalDate.of(2026,01,19));
            m2.setMemberType(MemberType.TEACHER);
            memberRepository.save(m2);

            //Loan
            Loan loan = new Loan();
            loan.setBook(b1);
            loan.setMember(m1);
            loan.setBorrowDate(LocalDate.now());
            loan.setDueDate(LocalDate.now().plusDays(14));
            loanRepository.save(loan);

            System.out.println("=== Database seeded with sample data ===");


        };
    }
}
