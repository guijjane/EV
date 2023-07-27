package com.example.projetffspring.Service;

import com.example.projetffspring.Model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role createRole(Role role);
    Role updateRole(Long id, Role updatedRole);
    void deleteRole(Long id);
}
