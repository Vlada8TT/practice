package com.example.demo.dto.requests;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class OrderRequestDto {

    @NotNull(message = "User id must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "User id length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private Integer user_id;

    @NotNull(message = "Time must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime time;

    @NotNull(message = "Status must not be null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 20, message = "Status length must be shorter than 21", groups = {OnCreate.class, OnUpdate.class})
    private String status;
}
