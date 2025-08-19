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
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categories;


    private String type;
    @OneToMany(mappedBy = "categorie",fetch = FetchType.LAZY)
    private List<Produit> produitss ;
}
