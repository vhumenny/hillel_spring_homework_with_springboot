package com.hillel.spring.hillel_spring_homework_with_springboot.service;

import com.hillel.spring.hillel_spring_homework_with_springboot.model.User;
import com.hillel.spring.hillel_spring_homework_with_springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.security.core.userdetails.User.*;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = userRepository.findByName(username);

        if (optional.isEmpty()) {
            throw new IllegalArgumentException("No User found with name "+ username);
        }
        User user = optional.get();

        return builder()
                .username(user.getName())
                .password(user.getPassword())
                .authorities(user.getRole().name())
                .build();
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
