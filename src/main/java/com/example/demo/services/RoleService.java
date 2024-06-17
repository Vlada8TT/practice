package com.example.demo.services;

import com.example.demo.dto.requests.RoleRequestDto;
import com.example.demo.dto.responses.RoleResponseDto;
import com.example.demo.persistence.entity.Role;

import java.util.List;

public interface RoleService {
    RoleResponseDto createRole(RoleRequestDto role);
    RoleResponseDto getRoleById(int id);
    List<RoleResponseDto> getAllRoles();
    RoleResponseDto updateRole(int id, RoleRequestDto role);
    void deleteRole(int id);
}