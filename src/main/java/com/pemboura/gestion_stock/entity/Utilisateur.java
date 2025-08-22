package com.pemboura.gestion_stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "utilisateur")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "utilisateur", length = 8)

public abstract class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom",length = 250)
    private String nom;

    @Column(name = "email",length = 250)
    private String email;

    //Relation avec la table Commande
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Commande> commandeList;

    // Constructeur

}
