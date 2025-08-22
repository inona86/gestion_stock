package com.pemboura.gestion_stock.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class ProduitsCommander {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // identifiant unique

    @ManyToOne
    @JoinColumn(name = "produit_id",nullable = false)
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "commande_id",nullable = false)
    private  Commande commande;

    private LocalDate dateCommandeProduit;
    private LocalTime heureDebut;
}
