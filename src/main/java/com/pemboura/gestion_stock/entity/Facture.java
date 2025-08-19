package com.pemboura.gestion_stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.Mapping;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facture_id;

    @Column(name = "amount",nullable = false,length = 255)
    private float amount;

    @OneToOne
    @JoinColumn(name = "facture_id")
    private Commande commande;
}
