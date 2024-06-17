package com.example.demo.dto.responses;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class OrderItemResponseDto {
    private Integer id;

    private Integer user_id;

    private Integer product_id;

    private Integer quantity;
}
