package com.pemboura.gestion_stock.repository;

import com.pemboura.gestion_stock.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
