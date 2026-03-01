package com.capgemini.Ass_Lms.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.Ass_Lms.Entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByMemberMemberId(Long memberId);
}
