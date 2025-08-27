package com.pemboura.gestion_stock.dto;

import com.pemboura.gestion_stock.entity.Commande;
import com.pemboura.gestion_stock.entity.Produit;

import java.util.List;

public record FournisseurDTO(
        int id,
        String nom,
        String prenom,
        String name,
        String email,
        List<Commande> commandeList,
        String reference,
        String immatriculation,
        List<Produit> produitList
){
}
