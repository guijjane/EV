package com.example.projetffspring.Repository;

import com.example.projetffspring.Model.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
//  Optional<AppUser> findByFullNameAndPassword(String fullName, String password);
    //Optional<AppUser> findByFullName(String fullName);
    Optional<AppUser> findByUsername(String username);
}

