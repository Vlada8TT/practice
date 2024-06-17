package com.example.demo.mapper;


import com.example.demo.dto.response.RoleResponseDto;
import com.example.demo.persistence.entity.Role;
import com.example.demo.dto.request.RoleRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResponseDto toDto(Role role);

    List<RoleResponseDto> toDto(List<Role> role);

    Role toEntity(RoleRequestDto dto);
}