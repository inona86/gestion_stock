package com.pemboura.gestion_stock.serviceDTO.serviceDtoUser;

import com.pemboura.gestion_stock.dto.UtilisateurAuthentifyDTO;
import com.pemboura.gestion_stock.dto.UtilisateurDTO;
import com.pemboura.gestion_stock.entity.Utilisateur;
import com.pemboura.gestion_stock.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceDtoUserImpl implements ServiceDtoUser{
    UserRepository userRepository;

    public UtilisateurDTO toDTo(Utilisateur utilisateur){
        return  new UtilisateurDTO(
              utilisateur.getId(),
              utilisateur.getNom(),
              utilisateur.getPrenom(),
              utilisateur.getNom() + "   " + utilisateur.getPrenom(),
              utilisateur.getEmail()
               // Period.between(utilisateur.getDateNaissance(), LocalDate.now()).getYears()
        );
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

    /*
    public UtilisateurDTO createation(Utilisateur utilisateur){
        return  new UtilisateurDTO(
                utilisateur.getId(),
                utilisateur.getNom(),
                utilisateur.getPrenom(),
                utilisateur.getNom() + "   " + utilisateur.getPrenom(),
                utilisateur.getEmail()
        );
    }

     */

}
