package com.example.demo.services;


import com.example.demo.persistence.entity.Address;

import java.util.List;

public interface AddressService {
    Address createAddress(Address address);
    Address getAddressById(int id);
    List<Address> getAllAddresses();
    Address updateAddress(int id, Address address);
    void deleteAddress(int id);
}