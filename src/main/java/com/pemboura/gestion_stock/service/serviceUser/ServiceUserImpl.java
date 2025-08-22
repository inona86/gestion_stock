package com.pemboura.gestion_stock.service.serviceUser;

import com.pemboura.gestion_stock.entity.Utilisateur;
import com.pemboura.gestion_stock.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUserImpl implements ServiceUser{

    private UserRepository userRepository;

    @Override
    public void create(Utilisateur utilisateur) {
        userRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> getAllUtilisateur() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Utilisateur> getUtilisateurById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return userRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
