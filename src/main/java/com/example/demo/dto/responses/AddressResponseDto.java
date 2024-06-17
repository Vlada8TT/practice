package com.example.demo.dto.responses;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class AddressResponseDto {
    private Integer id;

    private String apartment_number;

    private String house_number;

    private String city;

    private String street;

}
