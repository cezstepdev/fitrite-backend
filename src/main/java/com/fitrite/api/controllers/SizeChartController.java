package com.fitrite.api.controllers;

import com.fitrite.api.dto.SizeChartDTO;
import com.fitrite.api.models.SizeChart;
import com.fitrite.api.services.SizeChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/fitrite/size-chart")
public class SizeChartController {
    @Autowired
    private SizeChartService sizeChartService;

    @GetMapping("/{idSizeChart}")
    public SizeChartDTO getDtoById(@PathVariable(value = "idSizeChart") String idSizeChart) {
        return sizeChartService.getDtoById(idSizeChart);
    }

    @GetMapping
    public Page<SizeChartDTO> getAllDto(@RequestParam Optional<Integer> page,
                                              @RequestParam Optional<Integer> size,
                                              @RequestParam Optional<String> sort,
                                              @RequestParam Optional<Sort.Direction> direction) {
        return sizeChartService.getAllDto(PageRequest.of(
                        page.orElse(0),
                        size.orElse(10),
                        direction.orElse(Sort.Direction.ASC),
                        sort.orElse("idBrand"))
        );
    }

    @PostMapping
    public SizeChart saveDto(@RequestBody SizeChartDTO sizeChartDTO) {
        return sizeChartService.saveDto(sizeChartDTO);
    }

    @PutMapping
    public SizeChart updateDto(@RequestBody SizeChartDTO sizeChartDTO) {
        return sizeChartService.saveDto(sizeChartDTO);
    }

    /////////////////////////////////////////////////
    //Models requests
    @GetMapping("/model")
    public Page<SizeChart> getAll() {
        return sizeChartService.getAll();
    }

    @GetMapping("/model/{idSizeChart}")
    public SizeChart getById(@PathVariable(value = "idSizeChart") String idSizeChart) {
        return sizeChartService.getById(idSizeChart);
    }

    @PostMapping("/model")
    public SizeChart save(@RequestBody SizeChart sizeChart,
                          @RequestHeader String idBrand) {
        return sizeChartService.save(sizeChart, idBrand);
    }

    @DeleteMapping
    public void delete(@RequestParam String index) {
        sizeChartService.delete(index);
    }
}
