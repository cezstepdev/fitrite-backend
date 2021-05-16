package com.fitrite.api.repository;


import com.fitrite.api.models.Shoes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesRepository extends MongoRepository<Shoes, String> {
//    Shoes addShoes(Shoes shoes);
//    Iterable<Shoes> findAll();
//
//    Page<Shoes> findByIdBrand(Long idBrand, Pageable pageable);
//    Optional<Shoes> findByIdAndIdBrand(Long id, Long idBrand);
}
