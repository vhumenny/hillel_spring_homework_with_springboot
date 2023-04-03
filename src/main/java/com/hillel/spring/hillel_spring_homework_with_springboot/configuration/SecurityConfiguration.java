package com.hillel.spring.hillel_spring_homework_with_springboot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

public class SecurityConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(request ->
                        request.requestMatchers("/")
                                .hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                                .requestMatchers("/hr_info").hasRole("HR")
                                .requestMatchers("/manager_info").hasRole("MANAGER")
                                .anyRequest().authenticated()
                ).formLogin()
                .defaultSuccessUrl("/")
                .and()
                .logout();
        return httpSecurity.build();
    }

    @Bean
    protected UserDetailsService userDetailsService() throws Exception {
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        return users;
    }
}
