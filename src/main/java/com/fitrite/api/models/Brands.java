package com.fitrite.api.models;

import com.fitrite.api.models.media.Media;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "brands")
public class Brands {
    @Id
    private String idBrand;

    private String name;
    private Media media;

    public Brands(){}

    public Brands(String idBrand, String name, Media media) {
        this.idBrand = idBrand;
        this.name = name;
        this.media = media;
    }

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
