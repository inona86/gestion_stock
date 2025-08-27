package com.pemboura.gestion_stock.serviceDTO.serviceDtoFournisseur;

import com.pemboura.gestion_stock.dto.FournisseurDTO;
import com.pemboura.gestion_stock.entity.Fournisseur;
import org.springframework.stereotype.Service;

@Service
public class ServiceDTOFournisseurIpml {

    public FournisseurDTO toDTo(Fournisseur fournisseur){
        return  new FournisseurDTO(
                fournisseur.getId(),
                fournisseur.getNom(),
                fournisseur.getPrenom(),
                fournisseur.getNom() + "   " + fournisseur.getPrenom(),
                fournisseur.getEmail(),
                fournisseur.getCommandeList(),
                fournisseur.getReference(),
                fournisseur.getImmatriculation(),
                fournisseur.getProduits()
        );
    }
}
