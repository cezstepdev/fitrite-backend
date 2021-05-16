package com.fitrite.api.repository;


import com.fitrite.api.models.FavouriteShoes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteShoesRepository extends MongoRepository<FavouriteShoes, String> {
}
