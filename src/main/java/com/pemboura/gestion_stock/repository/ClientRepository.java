package com.pemboura.gestion_stock.repository;

import com.pemboura.gestion_stock.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Long searchByNom(String nom);
}
