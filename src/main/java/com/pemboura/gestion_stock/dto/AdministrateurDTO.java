package com.pemboura.gestion_stock.dto;

import com.pemboura.gestion_stock.entity.Commande;
import com.pemboura.gestion_stock.entity.Produit;

import java.util.List;

public record AdministrateurDTO (
        int id,
        String nom,
        String prenom,
        String name,
        //String email,
        List<Commande> commandeList,
        String droit
){
}
