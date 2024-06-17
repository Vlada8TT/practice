package com.example.demo;

import com.example.demo.persistence.entity.Address;
import com.example.demo.services.AddressService;
import com.example.demo.services.impl.AddressServiceImpl;


public class AddressServiceTest {
    public static void main(String[] args) {
        AddressService addressService = new AddressServiceImpl();

        // Создание и сохранение нового адреса
        Address address1 = new Address();
        address1.setApartment_number("101A");
        address1.setHouse_number("22");
        address1.setCity("Test City");
        address1.setStreet("Test Street");
        address1 = addressService.createAddress(address1);
        System.out.println("Created Address ID: " + address1.getId());

        // Получение адреса по ID
        Address fetchedAddress = addressService.getAddressById(address1.getId());
        System.out.println("Fetched Address ID: " + fetchedAddress.getId());
        System.out.println("City: " + fetchedAddress.getCity());

        // Обновление адреса
        Address updatedAddress = new Address();
        updatedAddress.setApartment_number("202B");
        updatedAddress.setHouse_number("33");
        updatedAddress.setCity("New City");
        updatedAddress.setStreet("New Street");
        updatedAddress = addressService.updateAddress(address1.getId(), updatedAddress);
        System.out.println("Updated Address ID: " + updatedAddress.getId());
        System.out.println("Updated City: " + updatedAddress.getCity());

        // Получение всех адресов
        System.out.println("All Addresses: ");
        for (Address address : addressService.getAllAddresses()) {
            System.out.println("ID: " + address.getId() + ", City: " + address.getCity());
        }

        // Удаление адреса
        addressService.deleteAddress(address1.getId());
        System.out.println("Address with ID " + address1.getId() + " deleted");

        // Проверка удаления
        Address deletedAddress = addressService.getAddressById(address1.getId());
        System.out.println("Fetched after deletion (should be null): " + deletedAddress);
    }
}
