package com.example.practice.models;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    @NotNull
    private int addressId;
    @Getter
    @Setter
    @NotNull
    private int roleId;
    @Getter
    @Setter

    @Email
    @NotEmpty
    private String email;
    @Getter
    @Setter
    @NotEmpty
    @Size(min = 8, max = 13)
    private String mobilePhone;
    @Getter
    @Setter

    @NotEmpty
    @Size(max = 20)
    private String name;
    @Getter
    @Setter
    @NotEmpty
    @Size(min = 6, max = 30)
    private String password;

}

