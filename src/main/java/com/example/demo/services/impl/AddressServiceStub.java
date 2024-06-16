package com.example.demo.services.impl;

import com.example.demo.persistence.entity.Address;
import com.example.demo.services.AddressService;

import java.util.List;


public class AddressServiceStub implements AddressService {
    @Override
    public Address createAddress(Address address) {
        return null;
    }

    @Override
    public Address getAddressById(int id) {
        return null;
    }

    @Override
    public List<Address> getAllAddresses() {
        return null;
    }

    @Override
    public Address updateAddress(int id, Address address) {
        return null;
    }

    @Override
    public void deleteAddress(int id) {

    }
}
