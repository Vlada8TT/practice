package com.example.demo.services.impl;

import com.example.demo.dto.requests.RoleRequestDto;
import com.example.demo.dto.responses.RoleResponseDto;
import com.example.demo.services.RoleService;
import com.example.demo.persistence.entity.Role;

import java.util.List;

public class RoleServiceStub implements RoleService {
    @Override
    public RoleResponseDto createRole(RoleRequestDto role) {
        return null;
    }

    @Override
    public RoleResponseDto getRoleById(int id) {
        return null;
    }

    @Override
    public List<RoleResponseDto> getAllRoles() {
        return null;
    }

    @Override
    public RoleResponseDto updateRole(int id, RoleRequestDto role) {
        return null;
    }

    @Override
    public void deleteRole(int id) {

    }
}
