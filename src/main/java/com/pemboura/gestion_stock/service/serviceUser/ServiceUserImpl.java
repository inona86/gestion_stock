package com.pemboura.gestion_stock.service.serviceUser;

import com.pemboura.gestion_stock.dto.UtilisateurDTO;
import com.pemboura.gestion_stock.entity.Utilisateur;
import com.pemboura.gestion_stock.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class ServiceUserImpl implements ServiceUser{

    private UserRepository userRepository;

    private Scanner scanner = new Scanner(System.in);

    public ServiceUserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    @Override
    public Long countByNom(String nom) {
        return userRepository.countByNom(nom);
    }

    @Override
    public boolean findByEmailAndPassword(String email, String password) {
        Utilisateur utilisateur = userRepository.findByEmailAndPassword(email,password);
        if (utilisateur != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String findUserEmailByNom(String nom) {
        return userRepository.findUserEmailByNom(nom);
    }

    /*
    @Override
    public String findUserEmailByNomAndImmatriculationByReference(String nom, String immatriculation) {
        return userRepository.findUserEmailByNomAndImmatriculationByReference(nom,immatriculation);
    }

     */

    /*
    @Override
    public String authentify(String email,String password){

        System.out.println("Entrez l'email de l'utilisateur");
        String emails = scanner.nextLine();
        System.out.println("Entrez le mot de passe de l'utilisateur");
        String passwords = scanner.nextLine();

        if (){
            return userRepository.authentify(utilisateur) + " l'utilisateur existe";
        } else {
            return userRepository.authentify(utilisateur) + "l'utilisteur n'existe pas";
        }
    }

     */
}
