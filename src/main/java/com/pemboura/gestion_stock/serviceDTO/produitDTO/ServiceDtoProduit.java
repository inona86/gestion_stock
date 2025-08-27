package com.pemboura.gestion_stock.serviceDTO.produitDTO;

import com.pemboura.gestion_stock.dto.ProduitDTO;
import com.pemboura.gestion_stock.entity.Utilisateur;
import org.springframework.stereotype.Service;

@Service
public interface ServiceDtoProduit {

    public void creation(ProduitDTO produitDTO);
}
