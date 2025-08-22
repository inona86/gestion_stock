package com.pemboura.gestion_stock.service.serviceAdministrateur;

import com.pemboura.gestion_stock.entity.Administrateur;

import java.util.List;
import java.util.Optional;

public interface ServiceAdmin {

    public void create(Administrateur administrateur);
    public List<Administrateur> getAllAdministrateur();
    public Optional<Administrateur> getAdministrateurById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
