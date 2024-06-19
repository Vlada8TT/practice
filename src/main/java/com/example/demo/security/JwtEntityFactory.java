package com.example.demo.security;

import com.example.demo.persistence.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public class JwtEntityFactory {

    public static JwtEntity create(final User user) {

        return new JwtEntity(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName())));
    }

}
