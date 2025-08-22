package com.pemboura.gestion_stock.service.serviceProduit;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Produit;

import java.util.List;
import java.util.Optional;

public interface ServiceProduit {

    public void create(Produit produit);
    public List<Produit> getAllProduit();
    public Optional<Produit> getProduitById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
