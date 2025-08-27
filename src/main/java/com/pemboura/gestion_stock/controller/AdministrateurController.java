package com.pemboura.gestion_stock.controller;

import com.pemboura.gestion_stock.dto.AdministrateurDTO;
import com.pemboura.gestion_stock.dto.UtilisateurDTO;
import com.pemboura.gestion_stock.entity.Administrateur;
import com.pemboura.gestion_stock.repository.AdministrateurRepository;
import com.pemboura.gestion_stock.service.serviceAdministrateur.ServiceAdmin;
import com.pemboura.gestion_stock.serviceDTO.serviceDtoAdministrateur.ServiceDTOAdministrateur;
import com.pemboura.gestion_stock.serviceDTO.serviceDtoFournisseur.ServiceDTOFournisseurIpml;
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

    @Autowired
    AdministrateurRepository administrateurRepository;

    @Autowired
    ServiceDTOAdministrateur serviceDTOAdministrateur;

    @PostMapping("/create")
    public ResponseEntity<Administrateur> create(@RequestBody Administrateur administrateur){
        serviceAdmin.create(administrateur);
        return ResponseEntity.ok(administrateur);
    }

    @GetMapping("/")
    public List<AdministrateurDTO> getAllUtilisateur(){
        return administrateurRepository.findAll().stream().map(serviceDTOAdministrateur::toDTo).toList();
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
