package com.example.practice.dto;

import com.example.practice.dto.validation.OnCreate;
import com.example.practice.dto.validation.OnUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
@Data
public class OrderDto {
    @NotNull(message = "Id must not be null.", groups = OnUpdate.class)
    private Integer id;

    @NotNull(message = "User id must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "User id length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private Integer user_id;

    @NotNull(message = "Time must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "Timestamp length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private Timestamp time;

    @NotNull(message = "Status must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "Status length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private String status;
}
