package com.fitrite.api.mapper;

import com.fitrite.api.dto.*;
import com.fitrite.api.models.*;
import com.fitrite.api.services.ShoesCollectionService;
import com.fitrite.api.services.BrandsService;
import com.fitrite.api.services.ShoesService;
import com.fitrite.api.services.SizeChartService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    @Autowired
    private ShoesService shoesService;

    @Autowired
    private SizeChartService sizeChartService;

    @Autowired
    private ShoesCollectionService shoesCollectionService;

    @Autowired
    private BrandsService brandsService;

    public ModelMapper shoesCollectionToDTO() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<ShoesCollection, ShoesCollectionDTO>() {
           @Override
           protected void configure() {
               map().setIdShoesCollection(source.getIdShoesCollection());
               map().setUid(source.getUid());

               map().setModelName(source.getShoes().getModelName());
               map().setFactor(source.getShoes().getFactor());
               map().setShoeMedia(source.getShoes().getMedia());
               map().setBrandName(source.getShoes().getBrand().getName());
               map().setBrandMedia(source.getShoes().getBrands().getMedia());

               map().setSizeUS(source.getSize().getUs());
               map().setSizeUK(source.getSize().getUk());
               map().setSizeEU(source.getSize().getEu());

               map().setHiddenSizeUS(source.getHiddenSize().getUs());
               map().setHiddenSizeUK(source.getHiddenSize().getUk());
               map().setHiddenSizeEU(source.getHiddenSize().getEu());

               map().setIdShoes(source.getShoes().getIdShoes());
               map().setIdSize(source.getSize().getIdSizeChart());
               map().setIdHiddenSize(source.getHiddenSize().getIdSizeChart());

           }
        });
        return modelMapper;
    }

    public ShoesCollection dtoToShoesCollection(ShoesCollectionDTO source) {
        ShoesCollection map = new ShoesCollection();

        map.setIdShoesCollection(source.getIdShoesCollection());
        map.setUid(source.getUid());

        map.setShoes(shoesService.getById(source.getIdShoes()));
        map.setSize(sizeChartService.getById(source.getIdSize()));
        map.setHiddenSize(sizeChartService.getById(source.getIdHiddenSize()));
        return map;
    }

    public ModelMapper brandsToDTO() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Brands, BrandsDTO>() {
            @Override
            protected void configure() {
                map().setIdBrand(source.getIdBrand());
                map().setName(source.getName());
                map().setMedia(source.getMedia());
            }
        });
        return modelMapper;
    }

    public Brands dtoToBrands(BrandsDTO source) {
        Brands map = new Brands();

        map.setIdBrand(source.getIdBrand());
        map.setName(source.getName());
        map.setMedia(source.getMedia());

        return map;
    }

    public ModelMapper favouritesShoesToDTO() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<FavouriteShoes, FavouriteShoesDTO>() {
            @Override
            protected void configure() {
                map().setIdFavorite(source.getIdFavorite());
                map().setUid(source.getUid());

                map().setShoesModelName(source.getShoes().getModelName());
                map().setShoesFactor(source.getShoes().getFactor());
                map().setMedia(source.getShoes().getMedia());

                map().setSizeUS(source.getSize().getUs());
                map().setSizeUK(source.getSize().getUk());
                map().setSizeEU(source.getSize().getEu());

                map().setIdShoes(source.getShoes().getIdShoes());
                map().setIdSize(source.getSize().getIdSizeChart());
                map().setIdShoesCollection(source.getBase().getIdShoesCollection());

            }
        });
        return modelMapper;
    }

    public FavouriteShoes dtoToFavouriteShoes(FavouriteShoesDTO source) {
        FavouriteShoes map = new FavouriteShoes();

        map.setIdFavorite(source.getIdFavorite());
        map.setUid(source.getUid());

        map.setShoes(shoesService.getById(source.getIdShoes()));
        map.setBase(shoesCollectionService.getById(source.getIdShoesCollection()));
        map.setSize(sizeChartService.getById(source.getIdSize()));

        return map;
    }

    public ModelMapper shoesToDTO() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Shoes, ShoesDTO>() {
            @Override
            protected void configure() {
                map().setIdShoes(source.getIdShoes());
                map().setModelName(source.getModelName());
                map().setFactor(source.getFactor());
                map().setColorWay(source.getColorWay());
                map().setGender(source.getGender());
                map().setReleaseDate(source.getReleaseDate());
                map().setTitle(source.getTitle());
                map().setMedia(source.getMedia());

                map().setBrandName(source.getBrand().getName());
                map().setBrandMedia(source.getBrand().getMedia());
                map().setIdBrand(source.getBrand().getIdBrand());

            }
        });
        return modelMapper;
    }

    public Shoes dtoToShoes(ShoesDTO source) {
        Shoes map = new Shoes();

        map.setIdShoes(source.getIdShoes());
        map.setModelName(source.getModelName());
        map.setFactor(source.getFactor());
        map.setColorWay(source.getColorWay());
        map.setGender(source.getGender());
        map.setReleaseDate(source.getReleaseDate());
        map.setTitle(source.getTitle());
        map.setMedia(source.getMedia());

        map.setBrand(brandsService.getById(source.getIdBrand()));

        return map;
    }

    public ModelMapper sizeChartToDTO() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<SizeChart, SizeChartDTO>() {
            @Override
            protected void configure() {
                map().setIdSize(source.getIdSizeChart());

                map().setUs(source.getUs());
                map().setUk(source.getUk());
                map().setEu(source.getEu());
                map().setType(source.getType());

                map().setBrandName(source.getBrands().getName());
                map().setBrandMedia(source.getBrands().getMedia());

                map().setIdBrand(source.getBrands().getIdBrand());
            }
        });
        return modelMapper;
    }

    public SizeChart dtoToSizeChart(SizeChartDTO source) {
        SizeChart map = new SizeChart();

        map.setIdSizeChart(source.getIdSize());
        map.setUs(source.getUs());
        map.setUk(source.getUk());
        map.setEu(source.getEu());
        map.setType(source.getType());

        map.setBrands(brandsService.getById(source.getIdBrand()));

        return map;
    }
}
