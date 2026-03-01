package com.capgemini.Ass_Lms.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.Ass_Lms.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}