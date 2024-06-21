package com.example.demo.mapper;

import com.example.demo.dto.request.CategoryRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.persistence.entity.Category;
import com.example.demo.persistence.entity.User;
import com.example.demo.dto.request.UserRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserResponseDto toDto(User user);

    void updateUserFromDto(UserRequestDto userRequestDto, @MappingTarget User user);

    List<UserResponseDto> toDto(List<User> user);

    User toEntity(UserRequestDto dto);
}