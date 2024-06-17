package com.example.demo.mappers;

import com.example.demo.dto.requests.AddressRequestDto;
import com.example.demo.dto.responses.AddressResponseDto;
import com.example.demo.dto.responses.UserResponseDto;
import com.example.demo.persistence.entity.User;
import com.example.demo.dto.requests.UserRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserResponseDto toDto (User user);
    List<UserResponseDto> toDto (List<User> user);
    User toEntity(UserRequestDto dto);
}
