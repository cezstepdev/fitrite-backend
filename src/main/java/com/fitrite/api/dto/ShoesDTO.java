package com.fitrite.api.dto;

import com.fitrite.api.models.media.Media;

public class ShoesDTO {
    private String idShoes;
    private String modelName;
    private double factor;
    private String colorWay;
    private String gender;
    private String releaseDate;
    private String title;
    private Media media;

    private String brandName;
    private Media brandMedia;
    private String idBrand;

    public String getIdShoes() {
        return idShoes;
    }

    public void setIdShoes(String idShoes) {
        this.idShoes = idShoes;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getColorWay() {
        return colorWay;
    }

    public void setColorWay(String colorWay) {
        this.colorWay = colorWay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Media getBrandMedia() {
        return brandMedia;
    }

    public void setBrandMedia(Media brandsImage) {
        this.brandMedia = brandsImage;
    }

    public String getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(String idBrand) {
        this.idBrand = idBrand;
    }
}
