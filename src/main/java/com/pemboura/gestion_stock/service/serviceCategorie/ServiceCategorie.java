package com.pemboura.gestion_stock.service.serviceCategorie;

import com.pemboura.gestion_stock.entity.Categorie;

import java.util.List;
import java.util.Optional;

public interface ServiceCategorie {

    public void create(Categorie categorie);
    public List<Categorie> getAllCategorie();
    public Optional<Categorie> getCategorieById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
