package com.example.demo.dto;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class OrderItemDto {
    @NotNull(message = "Id must not be null.", groups = OnUpdate.class)
    private Integer id;

    @NotNull(message = "User id must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "User id length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private Integer user_id;

    @NotNull(message = "Product id name must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "Product id length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private Integer product_id;

    @NotNull(message = "Quantity must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "Quantity length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private Integer quantity;
}
