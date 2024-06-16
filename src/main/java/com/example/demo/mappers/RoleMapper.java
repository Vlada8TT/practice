package com.example.demo.mappers;


import com.example.demo.persistence.entity.Role;
import com.example.demo.dto.RoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto toDto (Role role);
    Role toEntity(RoleDto dto);
}
