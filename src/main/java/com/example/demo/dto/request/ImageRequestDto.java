package com.example.demo.dto.request;

import com.example.demo.dto.validation.OnCreate;
import com.example.demo.dto.validation.OnUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class ImageRequestDto {
    @NotNull(message = "{path.notnull}", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 64, message = "{path.length}", groups = {OnCreate.class, OnUpdate.class})
    private String path;
}
