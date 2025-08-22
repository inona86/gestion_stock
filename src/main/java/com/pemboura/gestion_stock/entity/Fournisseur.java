
package com.pemboura.gestion_stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Fournisseur  extends Utilisateur {

    @Column(name = "reference",nullable = false,length = 250)
    private String reference;

    @Column(name = "immatriculation",nullable = false,length = 250)
    private  String immatriculation;

    // Relation avec la Table Produit
    @ManyToMany
    @JoinTable(name = "produitFournisseur")
    List<Produit> produits = new ArrayList<Produit>();


}