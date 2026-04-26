package com.anuj.library_management.domain.entity;

import com.anuj.library_management.domain.enums.MemberType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;
@Entity
@Table(name = "member")
public class Member {
    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", membershipDate=" + membershipDate +
                ", memberType=" + memberType +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "member_id",nullable = false,updatable = false)
    private UUID id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "membership_date",nullable = false)
    private LocalDate membershipDate;
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    public Member(){

    }

    public Member(String name, LocalDate membershipDate, MemberType memberType) {
        this.name = name;
        this.membershipDate = membershipDate;
        this.memberType = memberType;
    }
}
