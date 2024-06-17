package com.example.demo.mappers;


import com.example.demo.dto.requests.AddressRequestDto;
import com.example.demo.dto.responses.AddressResponseDto;
import com.example.demo.dto.responses.RoleResponseDto;
import com.example.demo.persistence.entity.Role;
import com.example.demo.dto.requests.RoleRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResponseDto toDto (Role role);
    List<RoleResponseDto> toDto (List<Role> role);
    Role toEntity(RoleRequestDto dto);
}
