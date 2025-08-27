package com.pemboura.gestion_stock.repository;

import com.pemboura.gestion_stock.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    Long countByNom(String nom);

    @Query("SELECT P FROM Produit P where P.categorie.type = :type")

    List<Produit> findProduitByCategorieType(@Param("type") String type);
   // Produit findByProduitName(String nom);
}
