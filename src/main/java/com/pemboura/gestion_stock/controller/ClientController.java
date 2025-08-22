package com.pemboura.gestion_stock.controller;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Client;
import com.pemboura.gestion_stock.service.serviceCategorie.ServiceCategorie;
import com.pemboura.gestion_stock.service.serviceClient.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")

public class ClientController {

    @Autowired
    ServiceClient serviceClient;

    @PostMapping("/create")
    public ResponseEntity<Client> create(@RequestBody Client client){
        serviceClient.create(client);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/")
    public List<Client> getAllClient(){
        return serviceClient.getAllClient();
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id){
        Optional<Client> optionalClient = serviceClient.getClientById(id);
        return optionalClient.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.noContent().build());
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        if (serviceClient.existsById(id)){
            serviceClient.deleteById(id);
            return  ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
