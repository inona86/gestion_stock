package com.pemboura.gestion_stock.controller;

import com.pemboura.gestion_stock.entity.Produit;
import com.pemboura.gestion_stock.service.serviceProduit.ServiceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/produit")
public class ProduitController {

    @Autowired
    private ServiceProduit serviceProduit ;

    @PostMapping("/create")
    public ResponseEntity<Produit> create(@RequestBody Produit produit){
        serviceProduit.create(produit);
        return ResponseEntity.ok(produit);
    }

    @GetMapping("/")
    public List<Produit> getAllProduct(){
        return  serviceProduit.getAllProduit();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getById(@PathVariable long id){
        Optional<Produit> optionalProduct = serviceProduit.getProduitById(id);
        return optionalProduct.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.noContent().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        if (serviceProduit.existsById(id)){
            serviceProduit.deleteById(id);
            return  ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
