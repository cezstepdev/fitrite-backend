package com.fitrite.api.dataacces;

import com.fitrite.api.models.Brands;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface BrandsDAO {
    Brands findById(String idBrand);
    Page<Brands> findAll(Pageable pageable);
    Brands save(Brands brands);
    void deleteAll();
    void deleteOne(String idBrand);
}
