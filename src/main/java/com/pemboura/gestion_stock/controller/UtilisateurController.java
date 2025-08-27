package com.pemboura.gestion_stock.controller;

import com.pemboura.gestion_stock.dto.UtilisateurDTO;
import com.pemboura.gestion_stock.entity.Utilisateur;
import com.pemboura.gestion_stock.repository.UserRepository;
import com.pemboura.gestion_stock.service.serviceUser.ServiceUser;
import com.pemboura.gestion_stock.serviceDTO.serviceDtoUser.ServiceDtoUserImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UtilisateurController {

    @Autowired
      ServiceUser serviceUser;

    @Autowired
      ServiceDtoUserImpl serviceDtoUserImpl;

    @Autowired
      UserRepository userRepository;


// Controlleur pour lea DTO

    public UtilisateurController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<UtilisateurDTO> getAllUtilisateur(){
        return userRepository.findAll().stream().map(serviceDtoUserImpl::toDTo).toList();
    }

    @PostMapping("/create")
    public ResponseEntity<Utilisateur> create(@RequestBody Utilisateur utilisateur){
        serviceUser.create(utilisateur);
        return ResponseEntity.ok(utilisateur);
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

    @GetMapping("/count/{nom}")
    public Long searchByNom(@PathVariable String nom){
        return serviceUser.countByNom(nom);
    }

    @GetMapping("/authentify/{email}/{password}")
    public boolean authentify(@PathVariable String email, String password){
        return serviceUser.findByEmailAndPassword(email,password);
    }

    @GetMapping("find/{nom}")
    public String findUserEmailByNom(@PathVariable String nom){
        return serviceUser.findUserEmailByNom(nom);
    }

    /*
    @GetMapping("find/{nom}/{immatriculation}")
    public String findUserEmailByNomAndImmatriculationByReference(@PathVariable String nom,String immatriculation){
        return serviceUser.findUserEmailByNomAndImmatriculationByReference(nom,immatriculation);
    }
     */

}
