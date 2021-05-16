package com.fitrite.api.dataacces;

import com.fitrite.api.dto.ShoesDTO;
import com.fitrite.api.models.Shoes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
//Operacje na modelach w bazie

public interface ShoesDAO {
    Shoes findById(String idShoes);
    Page<Shoes> findAll(Pageable pageable);
    Shoes save(Shoes shoes);
    void deleteAll();
    void deleteOne(String idShoes);
}
