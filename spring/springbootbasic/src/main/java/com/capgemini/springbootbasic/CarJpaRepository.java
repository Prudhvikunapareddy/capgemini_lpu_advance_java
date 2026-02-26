package com.capgemini.springbootbasic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CarJpaRepository extends JpaRepository<Car, Integer>{
	public Car getByPrice(double price);
	
	@Modifying
	@Transactional
	@Query("delete from Car c where c.brand =:carbrand")
	public void deleteByBrand(@Param("carbrand") String brand);
}
