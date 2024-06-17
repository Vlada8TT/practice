package com.example.demo.dto.response;

import lombok.Data;

@Data
public class AddressResponseDto {
    private Integer id;

    private String apartment_number;

    private String house_number;

    private String city;

    private String street;

}
