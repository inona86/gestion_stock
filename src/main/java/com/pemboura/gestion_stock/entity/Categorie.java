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
@DiscriminatorValue("categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categories;

    private String type;

    // Relation avec la table Produit
    @OneToMany(mappedBy = "categorie",fetch = FetchType.LAZY)
    private List<Produit> produitss ;
}
