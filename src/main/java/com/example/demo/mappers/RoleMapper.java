package com.example.demo.mappers;


import com.example.demo.persistence.entity.Role;
import com.example.demo.dto.RoleDto;

public interface RoleMapper {
    RoleDto toDto (Role role);
    Role toEntity(RoleDto dto);
}
