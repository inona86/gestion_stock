package com.pemboura.gestion_stock.repository;

import com.pemboura.gestion_stock.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
