package com.example.demo.dto.requests;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserRequestDto {
    @NotNull(message = "Name must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "Name length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @NotNull(message = "Mobile phone number must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "Mobile phone number length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private String mobilePhone;

    @NotNull(message = "Email must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 32, message = "Email length must be shorter than 33", groups = {OnCreate.class, OnUpdate.class})
    private String email;

    @NotNull(message = "Password must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 32, message = "Password length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private String password;

    @NotNull(message = "Address must not be null.", groups = {OnCreate.class, OnUpdate.class})
    private AddressRequestDto address;

    @NotNull(message = "Role must not be null.", groups = {OnCreate.class, OnUpdate.class})
    private RoleRequestDto role;
}