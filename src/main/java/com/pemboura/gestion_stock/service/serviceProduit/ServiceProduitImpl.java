package com.pemboura.gestion_stock.service.serviceProduit;

import com.pemboura.gestion_stock.entity.Produit;
import com.pemboura.gestion_stock.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProduitImpl implements ServiceProduit{

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
}
