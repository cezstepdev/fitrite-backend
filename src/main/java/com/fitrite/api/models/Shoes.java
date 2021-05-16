package com.fitrite.api.models;

import com.fitrite.api.models.media.Media;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shoes")
public class Shoes {
    @Id
    private String idShoes;

    private String modelName;
    private double factor;
    private String colorWay;
    private String gender;
    private String releaseDate;
    private String title;
    private Media media;

    @DBRef
    private Brands brands;

    public Shoes(){ }

    public Shoes(String idShoes, String modelName, double factor, String colorWay, String gender, String releaseDate, String title, Media media, Brands brands) {
        this.idShoes = idShoes;
        this.modelName = modelName;
        this.factor = factor;
        this.colorWay = colorWay;
        this.gender = gender;
        this.releaseDate = releaseDate;
        this.title = title;
        this.media = media;
        this.brands = brands;
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

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    public Brands getBrand() {
        return brands;
    }

    public void setBrand(Brands brands) {
        this.brands = brands;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String model) {
        this.modelName = model;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public String getIdShoes() {
        return idShoes;
    }

    public void setIdShoes(String idShoes) {
        this.idShoes = idShoes;
    }
}
