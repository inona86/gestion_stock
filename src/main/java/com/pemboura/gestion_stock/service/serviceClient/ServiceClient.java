package com.pemboura.gestion_stock.service.serviceClient;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ServiceClient {

    public void create(Client client);
    public List<Client> getAllClient();
    public Optional<Client> getClientById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
    public Long searchByNom(String nom);
}
