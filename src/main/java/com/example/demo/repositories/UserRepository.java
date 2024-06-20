package com.example.demo.repositories;


import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.persistence.entity.Role;
import com.example.demo.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByRole(Role roleName);

    Optional<User> findByName(String name);

    Boolean existsByEmail(String email);

    Boolean existsByMobilePhone(String mobilePhone);

    Optional<User> findByMobilePhone(String name);
}
