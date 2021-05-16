package com.fitrite.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "favouriteShoes")
public class FavouriteShoes {
    @Id
    private String idFavorite;
    private String uid;

    @DBRef
    private Shoes shoes;

    @DBRef
    private SizeChart size;

    @DBRef
    private ShoesCollection base;

    public FavouriteShoes(){}

    public FavouriteShoes(String idFavorite, String uid, Shoes shoes, SizeChart size, ShoesCollection base) {
        this.idFavorite = idFavorite;
        this.uid = uid;
        this.shoes = shoes;
        this.size = size;
        this.base = base;
    }

    public String getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(String idFavorite) {
        this.idFavorite = idFavorite;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String idUser) {
        this.uid = idUser;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public SizeChart getSize() {
        return size;
    }

    public void setSize(SizeChart size) {
        this.size = size;
    }

    public ShoesCollection getBase() {
        return base;
    }

    public void setBase(ShoesCollection base) {
        this.base = base;
    }
}
