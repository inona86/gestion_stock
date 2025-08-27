package com.pemboura.gestion_stock.controller;

import com.pemboura.gestion_stock.dto.ProduitDTO;
import com.pemboura.gestion_stock.entity.Produit;
import com.pemboura.gestion_stock.service.serviceProduit.ServiceProduit;
import com.pemboura.gestion_stock.serviceDTO.produitDTO.ServiceDtoProduit;
import com.pemboura.gestion_stock.serviceDTO.produitDTO.ServiceDtoProduitImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/produit")
public class ProduitController {

    @Autowired
    private ServiceProduit serviceProduit ;

    @Autowired
    private ServiceDtoProduitImpl serviceDtoProduitImpl;

    public ProduitController(ServiceDtoProduitImpl serviceDtoProduitImpl) {
        this.serviceDtoProduitImpl = serviceDtoProduitImpl;
    }

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

    // Mes methodes

    @PostMapping("/produitDTO")
    public ResponseEntity<String> create (@RequestBody ProduitDTO produitDTO){
        serviceDtoProduitImpl.creation(produitDTO);
        return ResponseEntity.ok("Produit enregistrer avec succes");
    }

    @GetMapping("/count/{nom}")
    public Long countProduit(@PathVariable String nom){
        return serviceProduit.countByNames(nom);
    }

    @GetMapping("/compte/{type}")
    public List<Produit> getAllProduct(@PathVariable String type){
        return serviceProduit.findProduitByCategorieType(type);
    }

    /*
    @GetMapping("/nom/{count}")
    public Produit countProduitByname(@PathVariable String nom){
        return serviceProduit.findByProduitName(nom);
    }

     */

}
