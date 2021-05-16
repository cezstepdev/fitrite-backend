package com.fitrite.api.dto;

import com.fitrite.api.models.media.Media;

public class ShoesCollectionDTO {
    private String idShoesCollection;
    private String uid;
    private String modelName;
    private double factor;
    private Media shoeMedia;
    private String brandName;
    private Media brandMedia;
    private double sizeUS;
    private double sizeUK;
    private String sizeEU;
    private double hiddenSizeUS;
    private double hiddenSizeUK;
    private String hiddenSizeEU;
    private String idShoes;
    private String idSize;
    private String idHiddenSize;

    public String getIdShoesCollection() {
        return idShoesCollection;
    }

    public void setIdShoesCollection(String idShoesCollection) {
        this.idShoesCollection = idShoesCollection;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public Media getShoeMedia() {
        return shoeMedia;
    }

    public void setShoeMedia(Media shoeMedia) {
        this.shoeMedia = shoeMedia;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Media getBrandMedia() {
        return brandMedia;
    }

    public void setBrandMedia(Media brandMedia) {
        this.brandMedia = brandMedia;
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

    public double getHiddenSizeUS() {
        return hiddenSizeUS;
    }

    public void setHiddenSizeUS(double hiddenSizeUS) {
        this.hiddenSizeUS = hiddenSizeUS;
    }

    public double getHiddenSizeUK() {
        return hiddenSizeUK;
    }

    public void setHiddenSizeUK(double hiddenSizeUK) {
        this.hiddenSizeUK = hiddenSizeUK;
    }

    public String getHiddenSizeEU() {
        return hiddenSizeEU;
    }

    public void setHiddenSizeEU(String hiddenSizeEU) {
        this.hiddenSizeEU = hiddenSizeEU;
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

    public String getIdHiddenSize() {
        return idHiddenSize;
    }

    public void setIdHiddenSize(String idHiddenSize) {
        this.idHiddenSize = idHiddenSize;
    }
}
