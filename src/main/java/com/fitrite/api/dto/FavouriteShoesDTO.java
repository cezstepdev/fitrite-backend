package com.fitrite.api.dto;

import com.fitrite.api.models.media.Media;

public class FavouriteShoesDTO {
    private String idFavorite;
    private String uid;
    private String shoesModelName;
    private double shoesFactor;
    private Media media;
    private double sizeUS;
    private double sizeUK;
    private String sizeEU;
    private String idShoes;
    private String idSize;
    private String idShoesCollection;

    public String getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(String idFavorite) {
        this.idFavorite = idFavorite;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getShoesModelName() {
        return shoesModelName;
    }

    public void setShoesModelName(String shoesModelName) {
        this.shoesModelName = shoesModelName;
    }

    public double getShoesFactor() {
        return shoesFactor;
    }

    public void setShoesFactor(double shoesFactor) {
        this.shoesFactor = shoesFactor;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public double getSizeUS() {
        return sizeUS;
    }

    public void setSizeUS(double sizeUS) {
        this.sizeUS = sizeUS;
    }

    public double getSizeUK() {
        return sizeUK;
    }

    public void setSizeUK(double sizeUK) {
        this.sizeUK = sizeUK;
    }

    public String getSizeEU() {
        return sizeEU;
    }

    public void setSizeEU(String sizeEU) {
        this.sizeEU = sizeEU;
    }

    public String getIdShoes() {
        return idShoes;
    }

    public void setIdShoes(String idShoes) {
        this.idShoes = idShoes;
    }

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

    public String getIdShoesCollection() {
        return idShoesCollection;
    }

    public void setIdShoesCollection(String idShoesCollection) {
        this.idShoesCollection = idShoesCollection;
    }
}
