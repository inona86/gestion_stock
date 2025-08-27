package com.pemboura.gestion_stock.repository;

import com.pemboura.gestion_stock.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    Categorie findByType(String type);
}
