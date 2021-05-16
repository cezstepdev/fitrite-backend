package com.fitrite.api.dataacces;

import com.fitrite.api.models.ShoesCollection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShoesCollectionDAO {
    ShoesCollection findById(String idShoesCollection);
    Page<ShoesCollection> findAll(Pageable pageable);
    ShoesCollection save(ShoesCollection shoesCollection);
    void deleteAll();
    void deleteOne(String idShoesCollection);
}
