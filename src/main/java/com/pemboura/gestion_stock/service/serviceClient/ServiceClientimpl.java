package com.pemboura.gestion_stock.service.serviceClient;

import com.pemboura.gestion_stock.entity.Client;
import com.pemboura.gestion_stock.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceClientimpl implements ServiceClient{

    private ClientRepository clientRepository;


    @Override
    public void create(Client client) {
        clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(long id) {
        return clientRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return clientRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Long searchByNom(String nom) {
        return clientRepository.searchByNom(nom);
    }
}
