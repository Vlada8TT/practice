package com.example.demo.dto.responses;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserResponseDto {
    private Integer id;

    private String name;

    private String mobilePhone;

    private String email;

    private AddressResponseDto address;

    private RoleResponseDto role;

}
