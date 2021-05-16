package com.fitrite.api.controllers;

import com.fitrite.api.dto.FavouriteShoesDTO;
import com.fitrite.api.models.FavouriteShoes;
import com.fitrite.api.services.FavouriteShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping("/api/fitrite/favourite-shoes")
@RestController
public class FavouriteShoesController {
    @Autowired
    private FavouriteShoesService favouriteShoesService;

    @GetMapping("/{idFavShoes}")
    public FavouriteShoesDTO getDtoById(@PathVariable(value = "idFavShoes") String idFavouriteShoes) {
        return favouriteShoesService.getDtoById(idFavouriteShoes);
    }

    @GetMapping
    public Page<FavouriteShoesDTO> getAllDto(@RequestParam Optional<Integer> page,
                                                   @RequestParam Optional<Integer> size,
                                                   @RequestParam Optional<String> sort,
                                                   @RequestParam Optional<Sort.Direction> direction) {
        return favouriteShoesService.getAllDto(PageRequest.of(
                page.orElse(0),
                size.orElse(10),
                direction.orElse(Sort.Direction.ASC),
                sort.orElse("idFavourite")));
    }

    @PostMapping
    public FavouriteShoes saveDto(@RequestBody FavouriteShoesDTO favouriteShoesDTO) {
        return favouriteShoesService.saveDto(favouriteShoesDTO);
    }

    @PutMapping
    public FavouriteShoes updateDto(@RequestBody FavouriteShoesDTO favouriteShoesDTO) {
        return favouriteShoesService.saveDto(favouriteShoesDTO);
    }

    /////////////////////////////////////////////////
    //Models request
    @GetMapping("/model")
    public Page<FavouriteShoes> getAll() {
        return favouriteShoesService.getAll();
    }

    @GetMapping("/model/{idFavShoes}")
    public FavouriteShoes getById(@PathVariable(value = "idFavShoes") String idFavShoes) {
        return favouriteShoesService.getById(idFavShoes);
    }

    @PostMapping("/model")
    public FavouriteShoes save(@RequestBody FavouriteShoes favouriteShoes,
                               @RequestHeader String idShoes,
                               @RequestHeader String idSize,
                               @RequestHeader String idShoesCollection) {
        return favouriteShoesService.save(favouriteShoes, idShoes, idSize, idShoesCollection);
    }

    @DeleteMapping
    public void delete(@RequestParam String index) {
        favouriteShoesService.delete(index);
    }
}
