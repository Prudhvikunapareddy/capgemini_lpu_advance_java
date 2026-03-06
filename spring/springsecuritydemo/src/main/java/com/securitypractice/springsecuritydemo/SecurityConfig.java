package com.securitypractice.springsecuritydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/practices").permitAll()
                        .requestMatchers("/admin").hasRole("USER"))
                .httpBasic(Customizer.withDefaults())
                .build();
    }
    @Bean
    public UserDetailsService getuserDetials() {
    	UserDetails admin = User .withUsername("admin").password("{noop}1234").roles("ADMIN").build();
    	UserDetails user=User.withUsername("bob").password("{noop}1212").roles("USER").build();
    	
    	return new InMemoryUserDetailsManager(user,admin);
    }
}