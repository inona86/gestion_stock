package com.pemboura.gestion_stock.service.serviceCommande;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Commande;

import java.util.List;
import java.util.Optional;

public interface ServiceCommande {

    public void create(Commande commande);
    public List<Commande> getAllCommande();
    public Optional<Commande> getCommandeById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
