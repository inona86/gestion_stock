package com.pemboura.gestion_stock.dto;

public record UtilisateurDTO(
         int id,
         String nom,
         String prenom,
         String name,
         String email
         //int age

) {
    // Le record permet de creer les object qui ne pourront plus etre changer
    // on aura plus besoin des setter
}
