package com.securitypractice.springsecurityconnection.securityConfig;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.securitypractice.springsecurityconnection.Entity.Account;
import com.securitypractice.springsecurityconnection.repo.AccountJpaRepository;

@Service
public class DbDetialsUserService implements UserDetailsService{
	
	private AccountJpaRepository repository;
	
	
	public DbDetialsUserService(AccountJpaRepository repository) {
		
		this.repository = repository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = repository.findByUsername(username)
		.orElseThrow(() -> new RuntimeException("User not found"));
		List<Simp>
		return new User(account.getUsername(),account.getPassword(),null);
	}
}
