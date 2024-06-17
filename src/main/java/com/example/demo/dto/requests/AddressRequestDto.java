package com.example.demo.dto.requests;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import lombok.Data;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Data
public class AddressRequestDto {
    @NotNull(message = "Apartment number must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "Apartment number length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private String apartment_number;

    @NotNull(message = "House number must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "House number length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private String house_number;

    @NotNull(message = "City name must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "City length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private String city;

    @NotNull(message = "Street name must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "Street name length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private String street;

}
