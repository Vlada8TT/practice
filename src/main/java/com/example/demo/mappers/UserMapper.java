package com.example.demo.mappers;

import com.example.demo.persistence.entity.User;
import com.example.demo.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto toDto (User user);
    User toEntity(UserDto dto);
}
