package com.example.practice.mappers;

import com.example.practice.dto.UserDto;
import com.example.practice.persistence.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto toDto (User user);
    User toEntity(UserDto dto);
}
