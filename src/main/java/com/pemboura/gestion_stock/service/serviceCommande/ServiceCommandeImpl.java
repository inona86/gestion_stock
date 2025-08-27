package com.pemboura.gestion_stock.service.serviceCommande;

import com.pemboura.gestion_stock.entity.Commande;
import com.pemboura.gestion_stock.repository.CommandeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceCommandeImpl implements ServiceCommande{

    private CommandeRepository commandeRepository;

    @Override
    public void create(Commande commande) {
       commandeRepository.save(commande);
    }

    @Override
    public List<Commande> getAllCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public Optional<Commande> getCommandeById(long id) {
        return commandeRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return commandeRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        commandeRepository.deleteById(id);
    }
}
