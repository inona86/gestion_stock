package com.pemboura.gestion_stock.service.serviceFournisseur;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface ServiceFournisseur {

    public void create(Fournisseur fournisseur);
    public List<Fournisseur> getAllFournisseur();
    public Optional<Fournisseur> getFournisseurById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
