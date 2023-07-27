package com.example.projetffspring.Service;

import com.example.projetffspring.Model.AppUser;
import com.example.projetffspring.Model.Role;
import com.example.projetffspring.Model.SaveUserRequest;
import com.example.projetffspring.Repository.AppUserRepository;
import com.example.projetffspring.Repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserService {

    private AppUserRepository appUserRepository;
    private RoleRepository roleRepository;


    public AppUser authenticate(String username, String password) {
        Optional<AppUser> userOptional = appUserRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            AppUser user = userOptional.get();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(password, user.getPasswordHash())) {
                return user;
            }
        }
        return userOptional.get();
    }
    public AppUser createUser(String username, String password,Long roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("role not found"));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordHash = passwordEncoder.encode(password);
        AppUser user = new AppUser();
        user.setUsername(username);
        user.setPasswordHash(passwordHash);
        user.getRoleList().add(role);
        appUserRepository.save(user);
        return user;
    }

    public AppUser saveAppUser(SaveUserRequest appUser) {
        final Role role = roleRepository.findById(appUser.getIdRole()).orElseThrow(() -> new RuntimeException("role introuvable"));
        AppUser user=new AppUser();
        user.setUsername(appUser.getUsername());
        user.getRoleList().add(role);
        return appUserRepository.save(user);
    }

    public AppUser getAppUserById(Long id) {
        return appUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));
    }

    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }

    public void deleteAppUserById(Long id) {
        appUserRepository.deleteById(id);
    }
}
