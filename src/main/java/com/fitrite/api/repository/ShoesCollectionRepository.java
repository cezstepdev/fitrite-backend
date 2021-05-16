package com.fitrite.api.repository;

import com.fitrite.api.models.ShoesCollection;
import org.springframework.data.mongodb.repository.MongoRepository;

//@Repository
public interface ShoesCollectionRepository extends MongoRepository<ShoesCollection, String> {
}
