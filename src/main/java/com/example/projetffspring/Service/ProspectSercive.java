package com.example.projetffspring.Service;

import com.example.projetffspring.Model.Prospect;
import com.example.projetffspring.Repository.ProspectRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProspectSercive {

    private ProspectRepository prospectRepository;


    public List<Prospect> getProspects() {
        List<Prospect> prospects = prospectRepository.findAll();
        return prospects;

    }

    public void saveProspect(Prospect prospect) {
        prospectRepository.save(prospect);
    }


    public Prospect getProspectById(Long id) {
        Optional<Prospect> prospectOptional = prospectRepository.findById(id);
        if (prospectOptional.isPresent()) {
            return prospectOptional.get();
        } else
            throw new IllegalArgumentException("Prospect non existant");
    }

    public void deleteProspect(Long id) {
        prospectRepository.deleteById(id);
    }


    public Prospect updateProspect(Long id, Prospect updatedProspect) {
        Optional<Prospect> prospectOptional = prospectRepository.findById(id);
        if (prospectOptional.isPresent()) {
            Prospect prospect = prospectOptional.get();
            prospect.setNom(updatedProspect.getNom());
            prospect.setPrenom(updatedProspect.getPrenom());
            prospect.setEmail(updatedProspect.getEmail());
            prospect.setTelephone(updatedProspect.getTelephone());
            prospect.setActiviter(updatedProspect.getActiviter());
            return prospectRepository.save(prospect);
        } else {
            throw new IllegalArgumentException("Prospect non existant");
        }
    }
    public List<Prospect>  searchProspect(String nom) {
        return prospectRepository.findByNomContaining(nom);
    }

}
