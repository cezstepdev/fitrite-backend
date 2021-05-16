package com.fitrite.api.dto;

import com.fitrite.api.models.media.Media;

public class SizeChartDTO {
    private String idSize;
    private double us;
    private double uk;
    private String eu;
    private char type;
    private String brandName;
    private Media media;
    private String idBrand;

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

    public double getUs() {
        return us;
    }

    public void setUs(double us) {
        this.us = us;
    }

    public double getUk() {
        return uk;
    }

    public void setUk(double uk) {
        this.uk = uk;
    }

    public String getEu() {
        return eu;
    }

    public void setEu(String eu) {
        this.eu = eu;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Media getMedia() {
        return media;
    }

    public void setBrandMedia(Media media) {
        this.media = media;
    }

    public String getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(String idBrand) {
        this.idBrand = idBrand;
    }
}
