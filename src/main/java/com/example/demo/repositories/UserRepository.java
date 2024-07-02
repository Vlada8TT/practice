package com.example.demo.repositories;


import com.example.demo.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    List<User> findAllByRoleId(Integer roleId);

    boolean existsByMobilePhone(String mobilePhone);

    boolean existsByEmail(String email);
}
