
package com.pemboura.gestion_stock.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("fournisseur")

public class Fournisseur  extends Utilisateur {

    @Column(name = "reference",nullable = false,length = 250)
    private String reference;

    @Column(name = "immatriculation",nullable = false,length = 250)
    private  String immatriculation;

    // Relation avec la Table Produit
    @ManyToMany
    @JoinTable(name = "produitFournisseur")
    List<Produit> produits = new ArrayList<Produit>();

    // Getters and Setters


    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}