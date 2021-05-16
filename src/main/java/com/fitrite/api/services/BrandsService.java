package com.fitrite.api.services;

import com.fitrite.api.dataacces.BrandsDAO;
import com.fitrite.api.dto.BrandsDTO;
import com.fitrite.api.mapper.Mapper;
import com.fitrite.api.models.Brands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BrandsService {

    @Autowired
    private BrandsDAO brandsDAO;

    @Autowired
    private Mapper mapper;

    public BrandsDTO getDtoById(String idBrand) {
        return mapper.brandsToDTO().map(brandsDAO.findById(idBrand), BrandsDTO.class);
    }

    public Page<BrandsDTO> getAllDto(PageRequest pageRequest) {
        Page<Brands> page = brandsDAO.findAll(pageRequest);
        Page<BrandsDTO> dtoPage = page.map(brand -> mapper.brandsToDTO().map(brand, BrandsDTO.class));

        return dtoPage;
    }

    public Brands saveDto(BrandsDTO brandsDTO) {
        return brandsDAO.save(mapper.dtoToBrands(brandsDTO));
    }

    /////////////////////////////////////////////////
    //Models services
    public Brands getById(String idBrand){
        return brandsDAO.findById(idBrand);
    }

    public void deleteAll() {
        brandsDAO.deleteAll();
    }

    public Page<Brands> getAll(){
        return brandsDAO.findAll(Pageable.unpaged());
    }

    public Brands save(Brands brands) {
        return brandsDAO.save(brands);
    }

    public void delete(String idBrands) {
        brandsDAO.deleteOne(idBrands);
    }
}
