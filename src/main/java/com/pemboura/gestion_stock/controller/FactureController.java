package com.pemboura.gestion_stock.controller;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Facture;
import com.pemboura.gestion_stock.service.serviceCategorie.ServiceCategorie;
import com.pemboura.gestion_stock.service.serviceFacture.ServiceFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/facture")
public class FactureController {

    @Autowired
    ServiceFacture serviceFacture;

    @PostMapping("/create")
    public ResponseEntity<Facture> create(@RequestBody Facture facture){
        serviceFacture.create(facture);
        return ResponseEntity.ok(facture);
    }

    @GetMapping("/")
    public List<Facture> getAllFacture(){
        return serviceFacture.getAllFacture();
    }

    @GetMapping("{id}")
    public ResponseEntity<Facture> getById(@PathVariable Long id){
        Optional<Facture> optionalFacture = serviceFacture.getFactureById(id);
        return optionalFacture.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.noContent().build());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        if (serviceFacture.existsById(id)){
            serviceFacture.deleteById(id);
            return  ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
