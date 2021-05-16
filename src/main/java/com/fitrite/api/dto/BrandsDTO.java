package com.fitrite.api.dto;

import com.fitrite.api.models.media.Media;

public class BrandsDTO {

    private String idBrand;
    private String name;
    private Media media;

    public String getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(String idBrand) {
        this.idBrand = idBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
