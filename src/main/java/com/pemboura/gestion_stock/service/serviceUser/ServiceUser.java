package com.pemboura.gestion_stock.service.serviceUser;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface ServiceUser {

    public void create(Utilisateur utilisateur);
    public List<Utilisateur> getAllUtilisateur();
    public Optional<Utilisateur> getUtilisateurById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
}
