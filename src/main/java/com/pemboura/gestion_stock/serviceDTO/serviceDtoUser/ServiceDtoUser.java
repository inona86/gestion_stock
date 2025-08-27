package com.pemboura.gestion_stock.serviceDTO.serviceDtoUser;

import com.pemboura.gestion_stock.dto.UtilisateurDTO;
import com.pemboura.gestion_stock.entity.Utilisateur;
import org.springframework.stereotype.Service;

@Service
public interface ServiceDtoUser {

    public UtilisateurDTO toDTo(Utilisateur utilisateur);
    boolean findByEmailAndPassword(String email,String password);
}
