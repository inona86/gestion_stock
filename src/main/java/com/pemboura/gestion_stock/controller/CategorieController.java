package com.pemboura.gestion_stock.controller;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Produit;
import com.pemboura.gestion_stock.service.serviceCategorie.ServiceCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categorie")
public class CategorieController {

    @Autowired
    ServiceCategorie serviceCategorie;

    @PostMapping("/create")
    public ResponseEntity<Categorie> create(@RequestBody Categorie categorie){
        serviceCategorie.create(categorie);
        return ResponseEntity.ok(categorie);
    }

    @GetMapping("/")
    public List<Categorie> getAllCategorie(){
      return serviceCategorie.getAllCategorie();
    }

    @GetMapping("{id}")
    public ResponseEntity<Categorie> getById(@PathVariable Long id){
        Optional<Categorie> optionalCategorie = serviceCategorie.getCategorieById(id);
        return optionalCategorie.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.noContent().build());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        if (serviceCategorie.existsById(id)){
            serviceCategorie.deleteById(id);
            return  ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


