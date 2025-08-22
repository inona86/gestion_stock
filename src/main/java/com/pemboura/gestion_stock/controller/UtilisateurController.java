package com.pemboura.gestion_stock.controller;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Utilisateur;
import com.pemboura.gestion_stock.service.serviceCategorie.ServiceCategorie;
import com.pemboura.gestion_stock.service.serviceUser.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UtilisateurController {

    @Autowired
    ServiceUser serviceUser;

    @PostMapping("/create")
    public ResponseEntity<Utilisateur> create(@RequestBody Utilisateur utilisateur){
        serviceUser.create(utilisateur);
        return ResponseEntity.ok(utilisateur);
    }

    @GetMapping("/")
    public List<Utilisateur> getAllUtilisateur(){
        return serviceUser.getAllUtilisateur();
    }

    @GetMapping("{id}")
    public ResponseEntity<Utilisateur> getById(@PathVariable Long id){
        Optional<Utilisateur> optionalUtilisateur = serviceUser.getUtilisateurById(id);
        return optionalUtilisateur.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.noContent().build());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        if (serviceUser.existsById(id)){
            serviceUser.deleteById(id);
            return  ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
