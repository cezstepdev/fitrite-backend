package com.fitrite.api.services;

import com.fitrite.api.dataacces.ShoesCollectionDAO;
import com.fitrite.api.dataacces.FavouriteShoesDAO;
import com.fitrite.api.dataacces.ShoesDAO;
import com.fitrite.api.dataacces.SizeChartDAO;
import com.fitrite.api.dto.BrandsDTO;
import com.fitrite.api.dto.FavouriteShoesDTO;
import com.fitrite.api.mapper.Mapper;
import com.fitrite.api.models.Brands;
import com.fitrite.api.models.FavouriteShoes;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class FavouriteShoesService {
    @Autowired
    private FavouriteShoesDAO favouriteShoesDAO;

    @Autowired
    private ShoesDAO shoesDAO;

    @Autowired
    private SizeChartDAO sizeChartDAO;

    @Autowired
    private ShoesCollectionDAO shoesCollectionDAO;

    @Autowired
    private Mapper mapper;

    public FavouriteShoesDTO getDtoById(String idFavouriteShoes) {
        return mapper.favouritesShoesToDTO().map(shoesCollectionDAO.findById(idFavouriteShoes), FavouriteShoesDTO.class);
    }

    public Page<FavouriteShoesDTO> getAllDto(PageRequest pageRequest) {
        Page<FavouriteShoes> favouriteShoesPages = favouriteShoesDAO.findAll(pageRequest);
        Page<FavouriteShoesDTO> dtoPage = favouriteShoesPages.map(favouriteShoes -> mapper.favouritesShoesToDTO().map(favouriteShoes, FavouriteShoesDTO.class));

        return dtoPage;
    }

    public FavouriteShoes saveDto(FavouriteShoesDTO favouriteShoesDTO) {
        return favouriteShoesDAO.save(mapper.dtoToFavouriteShoes(favouriteShoesDTO));
    }

    /////////////////////////////////////////////////
    //Models services
    public FavouriteShoes getById(String idFavShoes){
        return favouriteShoesDAO.findById(idFavShoes);
    }

    public void deleteAll() {
        favouriteShoesDAO.deleteAll();
    }

    public Page<FavouriteShoes> getAll(){
        return favouriteShoesDAO.findAll(Pageable.unpaged());
    }

    public FavouriteShoes save(FavouriteShoes favouriteShoes,
                               String idShoes,
                               String idSize,
                               String idShoesCollection) {
        favouriteShoes.setShoes(shoesDAO.findById(idShoes));
        favouriteShoes.setSize(sizeChartDAO.findById(idSize));
        favouriteShoes.setBase(shoesCollectionDAO.findById(idShoesCollection));
        return favouriteShoesDAO.save(favouriteShoes);
    }

    public void delete(String idFavouriteShoes) {
        favouriteShoesDAO.deleteOne(idFavouriteShoes);
    }
}
