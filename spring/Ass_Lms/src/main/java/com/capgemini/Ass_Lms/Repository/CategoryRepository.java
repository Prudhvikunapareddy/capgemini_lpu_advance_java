package com.capgemini.Ass_Lms.Repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.Ass_Lms.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
