package com.example.demo.dto.responses;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class OrderResponseDto {
    private Integer id;

    private Integer user_id;

    private LocalDateTime time;

    private String status;
}
