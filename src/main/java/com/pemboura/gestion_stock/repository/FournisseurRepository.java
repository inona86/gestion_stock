package com.pemboura.gestion_stock.repository;

import com.pemboura.gestion_stock.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
    Long countByNom(String nom);
}
