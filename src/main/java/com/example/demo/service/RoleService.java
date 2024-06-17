package com.example.demo.service;

import com.example.demo.dto.request.RoleRequestDto;
import com.example.demo.dto.response.RoleResponseDto;

import java.util.List;

public interface RoleService {
    RoleResponseDto createRole(RoleRequestDto role);

    RoleResponseDto getRoleById(int id);

    List<RoleResponseDto> getAllRoles();

    RoleResponseDto updateRole(int id, RoleRequestDto role);

    void deleteRole(int id);
}