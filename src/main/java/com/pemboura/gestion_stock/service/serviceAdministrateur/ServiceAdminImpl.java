package com.pemboura.gestion_stock.service.serviceAdministrateur;

import com.pemboura.gestion_stock.entity.Administrateur;
import com.pemboura.gestion_stock.repository.AdministrateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceAdminImpl implements ServiceAdmin{

    private AdministrateurRepository administrateurRepository;
    @Override
    public void create(Administrateur administrateur) {
        administrateurRepository.save(administrateur);
    }

    @Override
    public List<Administrateur> getAllAdministrateur() {
        return  administrateurRepository.findAll();
    }

    @Override
    public Optional<Administrateur> getAdministrateurById(long id) {
        return administrateurRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return administrateurRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        administrateurRepository.deleteById(id);
    }
}
