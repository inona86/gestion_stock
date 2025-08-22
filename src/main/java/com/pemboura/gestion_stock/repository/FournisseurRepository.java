package com.pemboura.gestion_stock.repository;

import com.pemboura.gestion_stock.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
