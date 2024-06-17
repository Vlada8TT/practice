package com.example.demo.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponseDto {
    private Integer id;

    private Integer user_id;

    private LocalDateTime time;

    private String status;
}
