package com.securitypractice.springsecurityconnection.service;



import org.springframework.security.crypto.password.PasswordEncoder;

import com.securitypractice.springsecurityconnection.Entity.Account;
import com.securitypractice.springsecurityconnection.dto.AccountRequestDTO;
import com.securitypractice.springsecurityconnection.repo.AccountJpaRepository;

public class AccoutnService {
	
	private AccountJpaRepository repository;
	
	private PasswordEncoder encode;

	public AccoutnService(AccountJpaRepository repository, PasswordEncoder encode) {
		
		this.repository =repository;
		this.encode = encode;
	}
	
	public void createAccount(AccountRequestDTO dto) {
		if(repository.existsByUsername(dto.getUsername())) {
			throw new RuntimeException("User Name Exist");
		}if(repository.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("User Email exist");
		}
		
		Account account = new Account();
		
		account.setUsername(dto.getUsername());
		account.setFullname(dto.getFullname());
		account.setPassword(dto.getPassword());
		account.setPhone(dto.getPhone());
		account.setCreatedAt(dto.getCreatedAt());
		account.setRole(dto.getRole());
	}
	
	

}