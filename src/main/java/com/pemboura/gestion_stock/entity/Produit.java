
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

public class Produit {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_produit;

@Column(name = "nom",length = 250)
private String nom;

@Column(name = "designation",length = 250)
private String designation;

@Column(name = "quantiteStock",length = 250)
private int quantiteStock;

@Column(name = "prix",length = 250)
private float prix;


@ManyToMany(mappedBy = "produits",fetch = FetchType.EAGER)

private List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();

@ManyToOne
@JoinColumn(name = "categorie_id")
private Categorie categorie;
}