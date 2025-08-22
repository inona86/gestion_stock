package com.pemboura.gestion_stock.service.serviceFournisseur;

import com.pemboura.gestion_stock.entity.Fournisseur;
import com.pemboura.gestion_stock.repository.FournisseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceFournisseurImpl implements ServiceFournisseur{

    private FournisseurRepository fournisseurRepository;

    @Override
    public void create(Fournisseur fournisseur) {
        fournisseurRepository.save(fournisseur);
    }

    @Override
    public List<Fournisseur> getAllFournisseur() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Optional<Fournisseur> getFournisseurById(long id) {
        return fournisseurRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return fournisseurRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        fournisseurRepository.deleteById(id);
    }
}
