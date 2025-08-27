package com.pemboura.gestion_stock.service.serviceFacture;

import com.pemboura.gestion_stock.entity.Facture;
import com.pemboura.gestion_stock.repository.FactureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceFactureImpl implements ServiceFacture{

    private FactureRepository factureRepository;

    @Override
    public void create(Facture facture) {
        factureRepository.save(facture);
    }

    @Override
    public List<Facture> getAllFacture() {
        return factureRepository.findAll();
    }

    @Override
    public Optional<Facture> getFactureById(long id) {
        return factureRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return factureRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        factureRepository.deleteById(id);
    }
}
