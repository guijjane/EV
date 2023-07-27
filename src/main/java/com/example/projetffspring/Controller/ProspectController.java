package com.example.projetffspring.Controller;


import com.example.projetffspring.Model.Prospect;
import com.example.projetffspring.Service.ProspectSercive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ProspectController {


    private ProspectSercive prospectSercive;

    @GetMapping("/ListProspect")
    public List<Prospect> listProspect(){
        return prospectSercive.getProspects();
    }

    @GetMapping("/showAddForm")
    public String showAddForm(@ModelAttribute("prospect") Prospect prospect) {
        return "add-prospect";
    }


    @PostMapping("/saveProspect")
    public Prospect saveProspect(@RequestBody Prospect prospect){
        prospectSercive.saveProspect(prospect);
        return prospect;
    }

    @GetMapping("/Prospect/{id}")
    public Prospect UnProspect(@PathVariable Long id){
       return prospectSercive.getProspectById(id);
    }


    @PutMapping("/updateProspect/{id}")
    public Prospect updateProspect(@PathVariable Long id, @RequestBody Prospect updatedProspect) {
        return  prospectSercive.updateProspect(id, updatedProspect);
    }


    @DeleteMapping("/deleteProspect/{id}")
    public void deleteProspect(@PathVariable Long id) {
        prospectSercive.deleteProspect(id);
    }

    @GetMapping("ListProspect/search")
    public List<Prospect> searchProspect(@RequestParam("nom") String nom) {
        return prospectSercive.searchProspect(nom);
    }





}
