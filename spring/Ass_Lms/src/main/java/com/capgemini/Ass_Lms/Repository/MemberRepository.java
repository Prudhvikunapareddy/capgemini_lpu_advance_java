package com.capgemini.Ass_Lms.Repository;


import com.capgemini.Ass_Lms.Entity.Member;   

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{

}