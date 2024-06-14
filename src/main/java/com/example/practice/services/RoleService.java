package com.example.practice.services;

import com.example.practice.models.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RoleService {
    Role createRole(Role role);
    Role getRoleById(int id);
    List<Role> getAllRoles();
    Role updateRole(int id, Role role);
    void deleteRole(int id);
}