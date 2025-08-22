package com.pemboura.gestion_stock.repository;

import com.pemboura.gestion_stock.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utilisateur,Long> {
}
