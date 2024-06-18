package com.example.demo.repositories;

import com.example.demo.persistence.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findAllByCity(String city);
    List<Address> findAllByStreet(String street);

}
