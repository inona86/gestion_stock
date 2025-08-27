package com.pemboura.gestion_stock.service.serviceUser;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Utilisateur;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ServiceUser {

    public void create(Utilisateur utilisateur);
    public List<Utilisateur> getAllUtilisateur();
    public Optional<Utilisateur> getUtilisateurById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
    public Long countByNom(String nom);
    public boolean findByEmailAndPassword(String email, String password);
    String findUserEmailByNom(String nom);

    //public String findUserEmailByNomAndImmatriculationByReference(@Param("nom,immatriculation") String nom, String immatriculation);

}
