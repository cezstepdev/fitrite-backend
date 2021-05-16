package com.fitrite.api.dataacces.implementation;

import com.fitrite.api.dataacces.BrandsDAO;
import com.fitrite.api.exceptions.ResourceNotFoundException;
import com.fitrite.api.models.Brands;
import com.fitrite.api.repository.BrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class BrandsDAOImplementation implements BrandsDAO {
    @Autowired
    BrandsRepository brandsRepository;

    @Override
    public Brands findById(String idBrand) {
        return brandsRepository.findById(idBrand)
                .orElseThrow(()-> new ResourceNotFoundException("brand: " + idBrand + " not found"));
    }

    @Override
    public Page<Brands> findAll(Pageable pageable) {
        return brandsRepository.findAll(pageable);
    }

    @Override
    public Brands save(Brands brands) {
        return brandsRepository.save(brands);
    }

    @Override
    public void deleteAll() {
        brandsRepository.deleteAll();
    }

    @Override
    public void deleteOne(String idBrand) {
        brandsRepository.deleteById(idBrand);
    }
}
