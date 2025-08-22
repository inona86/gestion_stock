package com.pemboura.gestion_stock.repository;

import com.pemboura.gestion_stock.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
