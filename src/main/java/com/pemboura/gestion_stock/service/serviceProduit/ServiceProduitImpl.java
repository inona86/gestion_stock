package com.pemboura.gestion_stock.service.serviceProduit;

import com.pemboura.gestion_stock.entity.Produit;
import com.pemboura.gestion_stock.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceProduitImpl implements ServiceProduit{

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public void create(Produit produit) {
        produitRepository.save(produit);
    }

    @Override
    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }

    @Override
    public Optional<Produit> getProduitById(long id) {
        return produitRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return produitRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        produitRepository.deleteById(id);
    }

    // Mes methodes
    @Override
    public Long countByNames(String nom) {
        return produitRepository.countByNom(nom);
    }

    @Override
    public List<Produit> findProduitByCategorieType(String type) {
        return produitRepository.findProduitByCategorieType(type);
    }

    /*
    @Override
    public Produit findByProduitName(String nom) {
        return produitRepository.findByProduitName(nom);
    }
     */


    /*
    @Override
    public Produit searchByProduct(String nom) {
        return produitRepository.findByProduitName(nom);
    }

     */
}
