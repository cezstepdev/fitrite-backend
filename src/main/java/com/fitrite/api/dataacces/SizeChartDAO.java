package com.fitrite.api.dataacces;

import com.fitrite.api.models.SizeChart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SizeChartDAO {
    SizeChart findById(String idSizeChart);
    Page<SizeChart> findAll(Pageable pageable);
    SizeChart save(SizeChart sizeChart);
    void deleteAll();
    void deleteOne(String idSizeChart);
}
