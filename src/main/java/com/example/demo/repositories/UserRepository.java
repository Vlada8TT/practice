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

    @Query(value = "SELECT CASE WHEN users.address_id IS NULL THEN false ELSE true END FROM users WHERE users.id = ?1",
    nativeQuery = true)
    boolean isAddressSet(int userId);

    boolean existsByMobilePhone(String mobilePhone);

    boolean existsByEmail(String email);
}
