package com.example.demo.services;

import com.example.demo.persistence.entity.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    Role getRoleById(int id);
    List<Role> getAllRoles();
    Role updateRole(int id, Role role);
    void deleteRole(int id);
}