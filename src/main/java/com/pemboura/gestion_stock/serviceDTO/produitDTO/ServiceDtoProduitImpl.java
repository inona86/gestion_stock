package com.pemboura.gestion_stock.serviceDTO.produitDTO;

import com.pemboura.gestion_stock.dto.FournisseurDTO;
import com.pemboura.gestion_stock.dto.ProduitDTO;
import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.entity.Fournisseur;
import com.pemboura.gestion_stock.entity.Produit;
import com.pemboura.gestion_stock.repository.CategorieRepository;
import com.pemboura.gestion_stock.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDtoProduitImpl {

    ProduitRepository produitRepository;

    CategorieRepository categorieRepository;

    public ServiceDtoProduitImpl(ProduitRepository produitRepository, CategorieRepository categorieRepository) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
    }

    public void creation(ProduitDTO produitDTO) {
        Produit produit = new Produit();
        produit.setNom(produitDTO.getNom());
        produit.setDesignation(produitDTO.getDesignation());
        produit.setQuantiteStock(produitDTO.getQuantiteStock());
        produit.setPrix(produitDTO.getPrix());
        Categorie categorie = categorieRepository.findByType(produitDTO.getType());
        produit.setCategorie(categorie);
        produitRepository.save(produit);
    }
}
