package com.example.projetffspring.Repository;

import com.example.projetffspring.Model.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProspectRepository extends JpaRepository<Prospect,Long> {

    List<Prospect> findByNomContaining(String nom);
}
