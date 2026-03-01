package com.capgemini.Ass_Lms.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.Ass_Lms.Entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}