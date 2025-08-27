package com.pemboura.gestion_stock.service.serviceCategorie;

import com.pemboura.gestion_stock.entity.Categorie;
import com.pemboura.gestion_stock.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceCategorieImpl implements ServiceCategorie{

    private CategorieRepository categorieRepository;

    @Override
    public void create(Categorie categorie) {
        categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }

    @Override
    public Optional<Categorie> getCategorieById(long id) {
        return categorieRepository.findById(id);
    }

    @Override
    public boolean existsById(long id) {
        return categorieRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
       categorieRepository.deleteById(id);
    }
}
