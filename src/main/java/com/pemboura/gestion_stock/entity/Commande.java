package com.pemboura.gestion_stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_commande;

    @OneToOne(mappedBy = "commande",fetch = FetchType.LAZY)
    private Facture facture;
    private String numeroCommande;



}
