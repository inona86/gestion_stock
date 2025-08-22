package com.pemboura.gestion_stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_commande;

    private String numeroCommande;

    // Relation avec la table Commande
    @OneToOne(mappedBy = "commande",fetch = FetchType.LAZY)
    private Facture facture;

    // Relation avec la table Produit
    @OneToMany(mappedBy = "commande",fetch = FetchType.LAZY)
    private List<ProduitsCommander> produitsCommanders;

    // Relation avec le User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Utilisateur user;

}
