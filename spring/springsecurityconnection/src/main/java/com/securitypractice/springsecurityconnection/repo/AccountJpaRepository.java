package com.securitypractice.springsecurityconnection.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securitypractice.springsecurityconnection.Entity.Account;

public interface AccountJpaRepository extends JpaRepository<Account, Integer>{
	public Optional<Account> findByUsername(String name);
	public boolean existsByUsername(String name);
	public boolean existsByEmail(String email);
}
