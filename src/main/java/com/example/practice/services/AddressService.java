package com.example.practice.services;
import com.example.practice.models.Address;


import java.util.List;

public interface AddressService {
    Address createAddress(Address address);
    Address getAddressById(int id);
    List<Address> getAllAddresses();
    Address updateAddress(int id, Address address);
    void deleteAddress(int id);
}