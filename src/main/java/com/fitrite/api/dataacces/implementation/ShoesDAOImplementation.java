package com.fitrite.api.dataacces.implementation;

import com.fitrite.api.exceptions.ResourceNotFoundException;
import com.fitrite.api.dataacces.ShoesDAO;
import com.fitrite.api.models.Shoes;
import com.fitrite.api.repository.ShoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ShoesDAOImplementation implements ShoesDAO {
    @Autowired
    private ShoesRepository shoesRepository;

    @Override
    public Shoes findById(String idShoes) {
        return shoesRepository.findById(idShoes)
                        .orElseThrow(()-> new ResourceNotFoundException("shoes: " + idShoes + " not found"));
    }

    @Override
    public Page<Shoes> findAll(Pageable pageable) {
        return shoesRepository.findAll(pageable);
    }

    @Override
    public Shoes save(Shoes shoes) {
        return shoesRepository.save(shoes);
    }

    @Override
    public void deleteAll() {
        shoesRepository.deleteAll();
    }

    @Override
    public void deleteOne(String idShoes) {
        shoesRepository.deleteById(idShoes);
    }
}
