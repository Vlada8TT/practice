package com.example.demo.mapper;

import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.persistence.entity.User;
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