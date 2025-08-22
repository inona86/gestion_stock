package com.pemboura.gestion_stock.controller;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Fournisseur;
import com.pemboura.gestion_stock.service.serviceCategorie.ServiceCategorie;
import com.pemboura.gestion_stock.service.serviceFournisseur.ServiceFournisseur;
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

    @PostMapping("/create")
    public ResponseEntity<Fournisseur> create(@RequestBody Fournisseur fournisseur){
        serviceFournisseur.create(fournisseur);
        return ResponseEntity.ok(fournisseur);
    }

    @GetMapping("/")
    public List<Fournisseur> getAllCategorie(){
        return serviceFournisseur.getAllFournisseur();
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
}
