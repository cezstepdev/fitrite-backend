package com.fitrite.api.services;

import com.fitrite.api.dataacces.BrandsDAO;
import com.fitrite.api.dataacces.SizeChartDAO;
import com.fitrite.api.dto.SizeChartDTO;
import com.fitrite.api.mapper.Mapper;
import com.fitrite.api.models.SizeChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class SizeChartService {
    @Autowired
    private SizeChartDAO sizeChartDAO;

    @Autowired
    private BrandsDAO brandsDAO;

    @Autowired
    private Mapper mapper;

    public SizeChartDTO getDtoById(String idSizeChart) {
        return mapper.sizeChartToDTO().map(sizeChartDAO.findById(idSizeChart), SizeChartDTO.class);
    }

    public Page<SizeChartDTO> getAllDto(PageRequest pageRequest) {
        Page<SizeChart> page = sizeChartDAO.findAll(pageRequest);
        Page<SizeChartDTO> dtoPage = page.map(brand -> mapper.sizeChartToDTO().map(brand, SizeChartDTO.class));

        return dtoPage;
    }

    public SizeChart saveDto(SizeChartDTO sizeChartDTO) {
        return sizeChartDAO.save(mapper.dtoToSizeChart(sizeChartDTO));
    }

    /////////////////////////////////////////////////
    //Models services
    public Page<SizeChart> getAll() {
        return sizeChartDAO.findAll(Pageable.unpaged());
    }

    public SizeChart getById(String idSizeChart) {
        return sizeChartDAO.findById(idSizeChart);
    }

    public void deleteAll() {
        sizeChartDAO.deleteAll();
    }

    public SizeChart save(SizeChart sizeChart, String idBrand) {
        sizeChart.setBrands(brandsDAO.findById(idBrand));
        return sizeChartDAO.save(sizeChart);
    }

    public void delete(String idSizeChart) {
        sizeChartDAO.deleteOne(idSizeChart);
    }
}
