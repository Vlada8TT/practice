package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public record OrderItemRequestDto(
        @NotNull(message = "{user_id.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{user_id.length}", groups = {OnCreate.class, OnUpdate.class})
        Integer user_id,

        @NotNull(message = "{product_id.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{product_id.length}", groups = {OnCreate.class, OnUpdate.class})
        Integer product_id,

        @NotNull(message = "{quantity.notnull}", groups = {OnCreate.class, OnUpdate.class})
        @Length(max = 20, message = "{quantity.length}", groups = {OnCreate.class, OnUpdate.class})
        Integer quantity
) {
}