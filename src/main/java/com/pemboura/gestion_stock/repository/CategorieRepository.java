package com.pemboura.gestion_stock.repository;

import com.pemboura.gestion_stock.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
