package com.pemboura.gestion_stock.controller;

import com.pemboura.gestion_stock.entity.Administrateur;
import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.service.serviceAdministrateur.ServiceAdmin;
import com.pemboura.gestion_stock.service.serviceCategorie.ServiceCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/admin")
public class AdministrateurController {

    @Autowired
    ServiceAdmin serviceAdmin;

    @PostMapping("/create")
    public ResponseEntity<Administrateur> create(@RequestBody Administrateur administrateur){
        serviceAdmin.create(administrateur);
        return ResponseEntity.ok(administrateur);
    }

    @GetMapping("/")
    public List<Administrateur> getAllAdmin(){
        return serviceAdmin.getAllAdministrateur();
    }

    @GetMapping("{id}")
    public ResponseEntity<Administrateur> getById(@PathVariable Long id){
        Optional<Administrateur> optionalAdministrateur = serviceAdmin.getAdministrateurById(id);
        return optionalAdministrateur.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.noContent().build());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        if (serviceAdmin.existsById(id)){
            serviceAdmin.deleteById(id);
            return  ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
