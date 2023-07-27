package com.example.projetffspring.Service;

import com.example.projetffspring.Model.Role;
import com.example.projetffspring.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        return roleOptional.orElse(null);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long id, Role updatedRole) {
        Role role = getRoleById(id);
        if (role != null) {
            role.setRoleName(updatedRole.getRoleName());
            return roleRepository.save(role);
        }
        return null;
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
