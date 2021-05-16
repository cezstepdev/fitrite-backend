package com.fitrite.api.services;

import com.fitrite.api.dataacces.BrandsDAO;
import com.fitrite.api.dataacces.ShoesDAO;
import com.fitrite.api.dto.ShoesDTO;
import com.fitrite.api.mapper.Mapper;
import com.fitrite.api.models.Shoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ShoesService {
    @Autowired
    private ShoesDAO shoesDAO;

    @Autowired
    private BrandsDAO brandsDAO;

    @Autowired
    private Mapper mapper;

    public ShoesDTO getDtoById(String idShoes) {
        return mapper.shoesToDTO().map(shoesDAO.findById(idShoes), ShoesDTO.class);
    }

    public Page<ShoesDTO> getAllDto(PageRequest pageRequest) {
        Page<Shoes> page = shoesDAO.findAll(pageRequest);
        Page<ShoesDTO> dtoPage = page.map(brand -> mapper.shoesToDTO().map(brand, ShoesDTO.class));

        return dtoPage;
    }

    public Shoes saveDto(ShoesDTO shoesDTO) {
        return shoesDAO.save(mapper.dtoToShoes(shoesDTO));
    }

    public Collection<ShoesDTO> getShoesByIdBrand(String idBrand) {
        return shoesDAO.findAll(Pageable.unpaged())
                .stream()
                .map(shoes -> mapper.shoesToDTO().map(shoes, ShoesDTO.class))
                .filter(shoes -> shoes.getIdBrand().equals(idBrand))
                .collect(Collectors.toList());
    }

    /////////////////////////////////////////////////
    //Models services
    public Page<Shoes> getAll() {
        return shoesDAO.findAll(Pageable.unpaged());
    }

    public Shoes getById(String idShoes) {
        return shoesDAO.findById(idShoes);
    }

    public void deleteAll() {
        shoesDAO.deleteAll();
    }

    public Shoes save(Shoes shoes, String idBrand) {
        shoes.setBrand(brandsDAO.findById(idBrand));
        return shoesDAO.save(shoes);
    }

    public void delete(String idShoes) {
        shoesDAO.deleteOne(idShoes);
    }
}
