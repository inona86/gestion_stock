package com.pemboura.gestion_stock.serviceDTO.serviceDtoAdministrateur;

import com.pemboura.gestion_stock.dto.AdministrateurDTO;
import com.pemboura.gestion_stock.dto.FournisseurDTO;
import com.pemboura.gestion_stock.entity.Administrateur;
import com.pemboura.gestion_stock.entity.Fournisseur;
import org.springframework.stereotype.Service;

@Service
public class ServiceDTOAdministrateur {
    public AdministrateurDTO toDTo(Administrateur administrateur){
        return  new AdministrateurDTO(
                administrateur.getId(),
                administrateur.getNom(),
                administrateur.getPrenom(),
                administrateur.getNom() + "   " + administrateur.getPrenom(),
                //administrateur.getEmail(),
                administrateur.getCommandeList(),
                administrateur.getDroit()
        );
    }
}
