package com.example.demo.services.impl;

import com.example.demo.services.RoleService;
import com.example.demo.persistence.entity.Role;

import java.util.List;

public class RoleServiceStub implements RoleService {
    @Override
    public Role createRole(Role role) {
        return null;
    }

    @Override
    public Role getRoleById(int id) {
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        return null;
    }

    @Override
    public Role updateRole(int id, Role role) {
        return null;
    }

    @Override
    public void deleteRole(int id) {

    }
}
