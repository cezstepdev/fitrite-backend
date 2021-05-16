package com.fitrite.api.controllers;

import com.fitrite.api.dto.ShoesCollectionDTO;
import com.fitrite.api.models.ShoesCollection;
import com.fitrite.api.services.ShoesCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/api/fitrite/shoes-collection")
@RestController
public class ShoesCollectionController {

    @Autowired
    private ShoesCollectionService shoesCollectionService;

    @GetMapping("/{idShoesCollection}")
    public ShoesCollectionDTO getDtoById(@PathVariable(value = "idShoesCollection") String idShoesCollection) {
        return shoesCollectionService.getDtoById(idShoesCollection);
    }

    @GetMapping
    public Page<ShoesCollectionDTO> getAllDto(@RequestParam Optional<Integer> page,
                                                    @RequestParam Optional<Integer> size,
                                                    @RequestParam Optional<String> sort,
                                                    @RequestParam Optional<Sort.Direction> direction) {
        return shoesCollectionService.getAllDto(PageRequest.of(
                page.orElse(0),
                size.orElse(10),
                direction.orElse(Sort.Direction.ASC),
                sort.orElse("idShoesCollection")));
    }


    @PostMapping
    public ShoesCollection saveDto(@RequestBody ShoesCollectionDTO shoesCollectionDTO) {
        return shoesCollectionService.saveDto(shoesCollectionDTO);
    }

    @PutMapping
    public ShoesCollection updateDto(@RequestBody ShoesCollectionDTO shoesCollectionDTO) {
        return shoesCollectionService.saveDto(shoesCollectionDTO);
    }

    /////////////////////////////////////////////////
    //Models requests
    @GetMapping("/model")
    public Page<ShoesCollection> getAll() {
        return shoesCollectionService.getAll();
    }

    @GetMapping("/model/{idShoesCollection}")
    public ShoesCollection getById(@PathVariable(value = "idShoesCollection") String idShoesCollection) {
        return shoesCollectionService.getById(idShoesCollection);
    }

    @PostMapping("/model")
    public ShoesCollection save(@RequestBody ShoesCollection shoesCollection,
                                @RequestHeader String idShoes,
                                @RequestHeader String idSize,
                                @RequestHeader String idHiddenSize) {
        return shoesCollectionService.save(shoesCollection, idShoes, idSize, idHiddenSize);
    }

    @DeleteMapping
    public void delete(@RequestParam String index) {
        shoesCollectionService.delete(index);
    }
}
