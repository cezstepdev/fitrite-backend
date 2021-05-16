package com.fitrite.api.repository;

import com.fitrite.api.models.Brands;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandsRepository extends MongoRepository<Brands, String> {

}
