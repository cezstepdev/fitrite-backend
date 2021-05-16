package com.fitrite.api.dataacces.implementation;

import com.fitrite.api.dataacces.SizeChartDAO;
import com.fitrite.api.exceptions.ResourceNotFoundException;
import com.fitrite.api.models.SizeChart;
import com.fitrite.api.repository.SizeChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SizeChartDAOImplementation implements SizeChartDAO {
    @Autowired
    private SizeChartRepository sizeChartRepository;

    @Override
    public SizeChart findById(String idSizeChart) {
        return sizeChartRepository.findById(idSizeChart)
                .orElseThrow(()-> new ResourceNotFoundException("size chart: " + idSizeChart + " not found"));
    }

    @Override
    public Page<SizeChart> findAll(Pageable pageable) {
        return sizeChartRepository.findAll(pageable);
    }

    @Override
    public SizeChart save(SizeChart sizeChart) {
        return sizeChartRepository.save(sizeChart);
    }

    @Override
    public void deleteAll() {
        sizeChartRepository.deleteAll();
    }

    @Override
    public void deleteOne(String idSizeChart) {
        sizeChartRepository.deleteById(idSizeChart);
    }
}
