package com.hillel.spring.hillel_spring_homework_with_springboot.security;

import com.hillel.spring.hillel_spring_homework_with_springboot.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityRole implements GrantedAuthority {
    private final Role role;
    @Override
    public String getAuthority() {
        return role.getName();
    }
}
