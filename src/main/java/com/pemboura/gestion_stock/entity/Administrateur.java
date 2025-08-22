package com.pemboura.gestion_stock.entity;

import jakarta.persistence.Entity;

@Entity

public class Administrateur extends Utilisateur {

    private String droit;
}
