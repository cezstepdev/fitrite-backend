package com.fitrite.api.dataacces.implementation;

import com.fitrite.api.dataacces.ShoesCollectionDAO;
import com.fitrite.api.exceptions.ResourceNotFoundException;
import com.fitrite.api.models.ShoesCollection;
import com.fitrite.api.repository.ShoesCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ShoesCollectionDAOImplementation implements ShoesCollectionDAO {
    @Autowired
    private ShoesCollectionRepository shoesCollectionRepository;

    @Override
    public ShoesCollection findById(String idShoesCollection) {
        return shoesCollectionRepository.findById(idShoesCollection)
                .orElseThrow(()-> new ResourceNotFoundException("base shoes: " + idShoesCollection + " not found"));
    }

    @Override
    public Page<ShoesCollection> findAll(Pageable pageable) {
        return shoesCollectionRepository.findAll(pageable);
    }

    @Override
    public ShoesCollection save(ShoesCollection shoesCollection) {
        return shoesCollectionRepository.save(shoesCollection);
    }

    @Override
    public void deleteAll() {
        shoesCollectionRepository.deleteAll();
    }

    @Override
    public void deleteOne(String idShoesCollection) {
        shoesCollectionRepository.deleteById(idShoesCollection);
    }
}
