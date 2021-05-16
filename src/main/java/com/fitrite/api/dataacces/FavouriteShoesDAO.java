package com.fitrite.api.dataacces;

import com.fitrite.api.models.FavouriteShoes;
import com.fitrite.api.models.Shoes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface FavouriteShoesDAO {
    FavouriteShoes findById(String idFavShoes);
    Page<FavouriteShoes> findAll(Pageable page);
    FavouriteShoes save(FavouriteShoes favouriteShoes);
    void deleteAll();
    void deleteOne(String idFavouriteShoes);
}
