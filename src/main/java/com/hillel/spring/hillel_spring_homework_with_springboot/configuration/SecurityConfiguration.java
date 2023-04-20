package com.hillel.spring.hillel_spring_homework_with_springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.httpBasic()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/products").hasAnyRole("ADMIN", "USER")
                .requestMatchers(HttpMethod.GET, "/products/*").hasAnyRole("ADMIN", "USER")
                .requestMatchers(HttpMethod.DELETE, "/products/*").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and().build();
    }

//    @Bean
//    protected UserDetailsService userDetailsService() {
//        return new JdbcUserDetailsManager(dataSource);
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
