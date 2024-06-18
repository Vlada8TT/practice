package com.example.demo.mapper;

import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.persistence.entity.User;
import com.example.demo.dto.request.UserRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserResponseDto toDto(User user);

    List<UserResponseDto> toDto(List<User> user);

    User toEntity(UserRequestDto dto);
}