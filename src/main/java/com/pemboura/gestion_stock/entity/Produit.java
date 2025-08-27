
package com.pemboura.gestion_stock.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("produit")

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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public Long getId_produit() {
        return id_produit;
    }

    public void setId_produit(Long id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<ProduitsCommander> getProduitsCommanderList() {
        return produitsCommanderList;
    }

    public void setProduitsCommanderList(List<ProduitsCommander> produitsCommanderList) {
        this.produitsCommanderList = produitsCommanderList;
    }

    // relation avec la Table Produit
    @ManyToMany(mappedBy = "produits",fetch = FetchType.EAGER)
    private List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();

    // Relation avec categorie
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    // Relation avec la table Commande
    @OneToMany(mappedBy = "produit",fetch = FetchType.LAZY)
    private List<ProduitsCommander> produitsCommanderList ;

}