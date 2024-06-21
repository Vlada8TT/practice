package com.example.demo.repositories;


import com.example.demo.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findById(Integer id);

    List<User> findAllByRoleId(Integer roleId);

    @Query(value = """
             SELECT exists(
                           SELECT 1
                           FROM orders
                           WHERE user_id = :userId
                             AND id = :orderId)
            """, nativeQuery = true)
    boolean isOrderOwner(
            @Param("userId") Integer userId,
            @Param("orderId") Integer orderId
    );

}
