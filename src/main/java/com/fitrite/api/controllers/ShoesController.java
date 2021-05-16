package com.fitrite.api.controllers;

import com.fitrite.api.dto.ShoesDTO;
import com.fitrite.api.models.Shoes;
import com.fitrite.api.services.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/api/fitrite/shoes")
@RestController
public class ShoesController {
    @Autowired
    private ShoesService shoesService;

    @GetMapping("/{idShoes}")
    public ShoesDTO getDtoById(@PathVariable(value = "idShoes") String idShoes) {
        return shoesService.getDtoById(idShoes);
    }

    @GetMapping
    public Page<ShoesDTO> getAllDto(@RequestParam Optional<Integer> page,
                                          @RequestParam Optional<Integer> size,
                                          @RequestParam Optional<String> sort,
                                          @RequestParam Optional<Sort.Direction> direction) {
        return shoesService.getAllDto(PageRequest.of(
                page.orElse(0),
                size.orElse(10),
                direction.orElse(Sort.Direction.ASC),
                sort.orElse("idBrand")));
    }

    @GetMapping("/brands/{idBrand}")
    public Collection<ShoesDTO> getShoesByIdBrand(@PathVariable(value = "idBrand") String idBrand) {
        return shoesService.getShoesByIdBrand(idBrand);
    }

    @PostMapping
    public Shoes saveDto(@RequestBody ShoesDTO shoesDTO) {
        return shoesService.saveDto(shoesDTO);
    }

    @PutMapping
    public Shoes updateDto(@RequestBody ShoesDTO shoesDTO) {
        return shoesService.saveDto(shoesDTO);
    }

    /////////////////////////////////////////////////
    //Models request
    @GetMapping("/model")
    public Page<Shoes> getAll() {
        return shoesService.getAll();
    }

    @GetMapping("model/{idShoes}")
    public Shoes getById(@PathVariable(value = "idShoes") String idShoes) {
        return shoesService.getById(idShoes);
    }

    @PostMapping("/model")
    public Shoes save(@RequestBody Shoes shoes,
                      @RequestHeader String idBrand) {
        return shoesService.save(shoes, idBrand);
    }

    @DeleteMapping
    public void delete(@RequestParam String index) {
        shoesService.delete(index);
    }
}
