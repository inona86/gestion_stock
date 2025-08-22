package com.pemboura.gestion_stock.repository;

import com.pemboura.gestion_stock.entity.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrateur,Long> {
}
