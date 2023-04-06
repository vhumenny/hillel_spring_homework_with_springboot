package com.hillel.spring.hillel_spring_homework_with_springboot.security;

import com.hillel.spring.hillel_spring_homework_with_springboot.model.Role;
import com.hillel.spring.hillel_spring_homework_with_springboot.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    //    private final DataSource dataSource;
    private final UserDetailsServiceImpl userService;

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(request ->
                        request.requestMatchers("/ping")
                        .permitAll()
                                .requestMatchers(HttpMethod.GET, "/products")
                                .hasAnyRole(Role.ROLE_USER.name(), Role.ROLE_ADMIN.name())
                                .requestMatchers(HttpMethod.DELETE, "/products/*")
                                .hasRole(Role.ROLE_ADMIN.name())
                                .requestMatchers(HttpMethod.POST, "/products")
                                .hasRole(Role.ROLE_ADMIN.name()))
                .formLogin().defaultSuccessUrl("/products", true)
                .and()
                .httpBasic().and().logout().permitAll();
        return httpSecurity.build();
    }

//    @Bean
//    protected UserDetailsService userDetailsService() {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    public DaoAuthenticationProvider getDaoAuthenticationProvider(UserDetailsServiceImpl userService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
