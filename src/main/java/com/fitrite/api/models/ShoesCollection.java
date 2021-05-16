package com.fitrite.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shoesCollection")
public class ShoesCollection {
    @Id
    private String idShoesCollection;
    private String uid;

    @DBRef
    private Shoes shoes;

    @DBRef
    private SizeChart size;

    @DBRef
    private SizeChart hiddenSize;

    public ShoesCollection(){}

    public ShoesCollection(String idShoesCollection, String uid, Shoes shoes, SizeChart size, SizeChart hiddenSize){
        this.idShoesCollection = idShoesCollection;
        this.uid = uid;
        this.shoes = shoes;
        this.size = size;
        this.hiddenSize = hiddenSize;
    }

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

    public SizeChart getHiddenSize() {
        return hiddenSize;
    }

    public void setHiddenSize(SizeChart hiddenSize) {
        this.hiddenSize = hiddenSize;
    }
}
