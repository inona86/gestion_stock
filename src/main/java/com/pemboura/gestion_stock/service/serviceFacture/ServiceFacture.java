package com.pemboura.gestion_stock.service.serviceFacture;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Facture;

import java.util.List;
import java.util.Optional;

public interface ServiceFacture {

    public void create(Facture facture);
    public List<Facture> getAllFacture();
    public Optional<Facture> getFactureById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
