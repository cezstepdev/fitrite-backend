package com.fitrite.api.controllers;

import com.fitrite.api.dto.BrandsDTO;
import com.fitrite.api.models.Brands;
import com.fitrite.api.services.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/api/fitrite/brands")
@RestController
public class BrandsController {

    @Autowired
    BrandsService brandsService;

    @GetMapping("/{idBrand}")
    public BrandsDTO getDtoById(@PathVariable(value = "idBrand") String idBrand) {
        return brandsService.getDtoById(idBrand);
    }

    @GetMapping
    public Page<BrandsDTO> getAllDto(@RequestParam Optional<Integer> page,
                                           @RequestParam Optional<Integer> size,
                                           @RequestParam Optional<String> sort,
                                           @RequestParam Optional<Sort.Direction> direction) {
        return brandsService.getAllDto(PageRequest.of(
                page.orElse(0),
                size.orElse(10),
                direction.orElse(Sort.Direction.ASC),
                sort.orElse("idBrand")));
    }

    @PostMapping
    public Brands saveDto(@RequestBody BrandsDTO brandsDTO) {
        return brandsService.saveDto(brandsDTO);
    }

    @PutMapping
    public Brands updateDto(@RequestBody BrandsDTO brandsDTO) {
        return brandsService.saveDto(brandsDTO);
    }

    /////////////////////////////////////////////////
    //Models request
    @GetMapping("/model")
    public Page<Brands> getAll() {
        return brandsService.getAll();
    }

    @GetMapping("/model/{idBrand}")
    public Brands getById(@PathVariable(value = "idBrand") String idBrand) {
        return brandsService.getById(idBrand);
    }

    @PostMapping("/model")
    public Brands save(@RequestBody Brands brands) {
        return brandsService.save(brands);
    }

    @DeleteMapping
    public void delete(@RequestParam String index) {
        brandsService.delete(index);
    }
}
