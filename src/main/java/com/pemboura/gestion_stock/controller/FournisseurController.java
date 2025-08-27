package com.pemboura.gestion_stock.controller;

import com.pemboura.gestion_stock.dto.FournisseurDTO;
import com.pemboura.gestion_stock.dto.UtilisateurDTO;
import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Fournisseur;
import com.pemboura.gestion_stock.repository.FournisseurRepository;
import com.pemboura.gestion_stock.service.serviceCategorie.ServiceCategorie;
import com.pemboura.gestion_stock.service.serviceFournisseur.ServiceFournisseur;
import com.pemboura.gestion_stock.serviceDTO.serviceDtoFournisseur.ServiceDTOFournisseurIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/fournisseur")

public class FournisseurController {

    @Autowired
    ServiceFournisseur serviceFournisseur;

    @Autowired
    FournisseurRepository fournisseurRepository;

    @Autowired
    ServiceDTOFournisseurIpml serviceDTOFournisseurIpml;

    @PostMapping("/create")
    public ResponseEntity<Fournisseur> create(@RequestBody Fournisseur fournisseur){
        serviceFournisseur.create(fournisseur);
        return ResponseEntity.ok(fournisseur);
    }

    @GetMapping("/")
    public List<FournisseurDTO> getAllUtilisateur(){
        return fournisseurRepository.findAll().stream().map(serviceDTOFournisseurIpml::toDTo).toList();
    }

    @GetMapping("{id}")
    public ResponseEntity<Fournisseur> getById(@PathVariable Long id){
        Optional<Fournisseur> optionalFournisseur = serviceFournisseur.getFournisseurById(id);
        return optionalFournisseur.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.noContent().build());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        if (serviceFournisseur.existsById(id)){
            serviceFournisseur.deleteById(id);
            return  ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Mes propres methodes
    @GetMapping("/count/{nom}")
    public Long searchByNom(@PathVariable String nom){
        return serviceFournisseur.countByName(nom);
    }
}
