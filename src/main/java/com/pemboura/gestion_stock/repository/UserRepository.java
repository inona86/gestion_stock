package com.pemboura.gestion_stock.repository;

import com.pemboura.gestion_stock.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur,Long> {
    Long countByNom(String nom);
    Utilisateur findByEmailAndPassword(String email,String password);

    @Query("SELECT us.email FROM Utilisateur us WHERE us.nom = :nom")
    String findUserEmailByNom(@Param("nom") String nom);

    //@Query("SELECT * FROM Utilisateur")
    //String findAll(@Param("nom") String nom);

   /*@Query("SELECT us.email FROM Utilisateur us INNER JOIN f.reference FROM Fournisseur f WHERE us.nom = :nom JOIN f.immatriculation = :immatriculation")
    String findUserEmailByNomAndImmatriculationByReference(@Param("nom,immatriculation") String nom,String immatriculation);

    */
}
