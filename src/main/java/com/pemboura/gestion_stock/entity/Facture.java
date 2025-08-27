package com.pemboura.gestion_stock.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("facture")

public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facture_id;

    @Column(name = "amount",nullable = false,length = 255)
    private float amount;

    // Relation avec la Table Commande
    @OneToOne
    @JoinColumn(name = "facture_id")
    private Commande commande;
}
