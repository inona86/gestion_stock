
package com.pemboura.gestion_stock.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Fournisseur {

@Id
@Column(name = "reference",nullable = false,length = 250)
private String reference;

@Column(name = "immatriculation",nullable = false,length = 250)
private  String immatriculation;

@ManyToMany
@JoinTable(name = "produitFournisseur")
List<Produit> produits = new ArrayList<Produit>();

}