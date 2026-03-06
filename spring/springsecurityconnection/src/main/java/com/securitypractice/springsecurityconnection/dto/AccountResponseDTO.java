package com.securitypractice.springsecurityconnection.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class AccountResponseDTO {
	private String username;
	
	private String email;
	private String phone;
	private String fullname;
	private String role;
	private LocalDateTime createdAt = LocalDateTime.now();
}
