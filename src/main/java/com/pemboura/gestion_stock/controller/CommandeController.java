package com.pemboura.gestion_stock.controller;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Commande;
import com.pemboura.gestion_stock.service.serviceCategorie.ServiceCategorie;
import com.pemboura.gestion_stock.service.serviceCommande.ServiceCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/commande")
public class CommandeController {

    @Autowired
    ServiceCommande serviceCommande;

    @PostMapping("/create")
    public ResponseEntity<Commande> create(@RequestBody Commande commande){
        serviceCommande.create(commande);
        return ResponseEntity.ok(commande);
    }

    @GetMapping("/")
    public List<Commande> getAllCommande(){
        return serviceCommande.getAllCommande();
    }

    @GetMapping("{id}")
    public ResponseEntity<Commande> getById(@PathVariable Long id){
        Optional<Commande> optionalCategorie = serviceCommande.getCommandeById(id);
        return optionalCategorie.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.noContent().build());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        if (serviceCommande.existsById(id)){
            serviceCommande.deleteById(id);
            return  ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
