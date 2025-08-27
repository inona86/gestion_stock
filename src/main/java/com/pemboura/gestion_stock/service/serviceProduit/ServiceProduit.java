package com.pemboura.gestion_stock.service.serviceProduit;

import com.pemboura.gestion_stock.dto.ProduitDTO;
import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Produit;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ServiceProduit {

    public void create(Produit produit);
    public List<Produit> getAllProduit();
    public Optional<Produit> getProduitById(long id);
    public boolean existsById (long id);
    public  void deleteById(long id);
    public Long countByNames(String nom);
    List<Produit> findProduitByCategorieType(String type);
   // public Produit findByProduitName(String nom);
    /*
    public Produit searchByProduct(String nom);
    public Produit countProduitByname();

     */


}
