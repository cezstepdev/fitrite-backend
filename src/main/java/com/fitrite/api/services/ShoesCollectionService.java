package com.fitrite.api.services;

import com.fitrite.api.dataacces.ShoesCollectionDAO;
import com.fitrite.api.dataacces.ShoesDAO;
import com.fitrite.api.dataacces.SizeChartDAO;
import com.fitrite.api.dto.BrandsDTO;
import com.fitrite.api.dto.ShoesCollectionDTO;
import com.fitrite.api.mapper.Mapper;
import com.fitrite.api.models.Brands;
import com.fitrite.api.models.ShoesCollection;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ShoesCollectionService {
    @Autowired
    private ShoesCollectionDAO shoesCollectionDAO;

    @Autowired
    private ShoesDAO shoesDAO;

    @Autowired
    private SizeChartDAO sizeChartDAO;

    @Autowired
    private Mapper mapper;

    //DTO functions
    public ShoesCollectionDTO getDtoById(String idShoesCollection) {
        return mapper.shoesCollectionToDTO().map(shoesCollectionDAO.findById(idShoesCollection), ShoesCollectionDTO.class);
    }

    public Page<ShoesCollectionDTO> getAllDto(PageRequest pageRequest) {
        Page<ShoesCollection> page = shoesCollectionDAO.findAll(pageRequest);
        Page<ShoesCollectionDTO> dtoPage = page.map(brand -> mapper.shoesCollectionToDTO().map(brand, ShoesCollectionDTO.class));

        return dtoPage;
    }

    public ShoesCollection saveDto(ShoesCollectionDTO shoesCollectionDTO) {
        return shoesCollectionDAO.save(mapper.dtoToShoesCollection(shoesCollectionDTO));
    }

    /////////////////////////////////////////////////
    //Models services
    public ShoesCollection getById(String idShoesCollection){
        return shoesCollectionDAO.findById(idShoesCollection);
    }

    public void deleteAll() {
        shoesCollectionDAO.deleteAll();
    }

    public Page<ShoesCollection> getAll(){
        return shoesCollectionDAO.findAll(Pageable.unpaged());
    }

    public ShoesCollection save(ShoesCollection shoesCollection,
                                String idShoes,
                                String idSize,
                                String idHiddenSize) {
        shoesCollection.setShoes(shoesDAO.findById(idShoes));
        shoesCollection.setSize(sizeChartDAO.findById(idSize));
        shoesCollection.setHiddenSize(sizeChartDAO.findById(idHiddenSize));

        return shoesCollectionDAO.save(shoesCollection);
    }

    public void delete(String idShoesCollection) {
        shoesCollectionDAO.deleteOne(idShoesCollection);
    }
}
