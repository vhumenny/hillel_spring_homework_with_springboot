package com.hillel.spring.hillel_spring_homework_with_springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.httpBasic()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/products").hasAnyRole("ADMIN", "USER")
                .requestMatchers(HttpMethod.GET, "/products/*").hasAnyRole("ADMIN", "USER")
                .requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
                .requestMatchers("/ping").permitAll()
                .and().csrf().disable()
                .build();
    }

    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
