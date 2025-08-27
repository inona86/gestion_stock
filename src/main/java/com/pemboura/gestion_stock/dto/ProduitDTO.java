package com.pemboura.gestion_stock.dto;

public class ProduitDTO {


    String  nom;
    String designation;
    int quantiteStock;
    float prix;
    String type;

    public ProduitDTO(String nom, String designation, int quantiteStock, float prix,String type) {
        this.nom = nom;
        this.designation = designation;
        this.quantiteStock = quantiteStock;
        this.prix = prix;
        this.type = type;
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

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
