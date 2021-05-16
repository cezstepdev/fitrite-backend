package com.fitrite.api.dataacces.implementation;

import com.fitrite.api.dataacces.FavouriteShoesDAO;
import com.fitrite.api.exceptions.ResourceNotFoundException;
import com.fitrite.api.models.FavouriteShoes;
import com.fitrite.api.repository.FavouriteShoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FavouriteShoesDAOImplementation implements FavouriteShoesDAO {
    @Autowired
    private FavouriteShoesRepository favouriteShoesRepository;

    @Override
    public FavouriteShoes findById(String idFavShoes) {
        return favouriteShoesRepository.findById(idFavShoes)
                .orElseThrow(()-> new ResourceNotFoundException("favourite shoes: " + idFavShoes + " not found"));
    }

    @Override
    public Page<FavouriteShoes> findAll(Pageable page) {
        return favouriteShoesRepository.findAll(page);
    }

    @Override
    public FavouriteShoes save(FavouriteShoes favShoes) {
        return favouriteShoesRepository.save(favShoes);
    }

    @Override
    public void deleteAll() {
        favouriteShoesRepository.deleteAll();
    }

    @Override
    public void deleteOne(String idFavouriteShoes) {
        favouriteShoesRepository.deleteById(idFavouriteShoes);
    }
}
