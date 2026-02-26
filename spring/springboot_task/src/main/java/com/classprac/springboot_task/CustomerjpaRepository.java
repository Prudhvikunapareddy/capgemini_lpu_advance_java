package com.classprac.springboot_task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerjpaRepository  extends JpaRepository<Customer, Integer>{
	
}
