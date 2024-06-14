package com.example.practice.mappers;


import com.example.practice.dto.RoleDto;
import com.example.practice.persistence.entities.Role;

public interface RoleMapper {
    RoleDto toDto (Role role);
    Role toEntity(RoleDto dto);
}
