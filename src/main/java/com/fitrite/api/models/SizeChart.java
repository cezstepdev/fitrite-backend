package com.fitrite.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "sizeChart")
public class SizeChart {
    @Id
    private String idSizeChart;
    private double us;
    private double uk;
    private String eu;

    @Field(name = "type")
    private char type = 'm';

    @DBRef
    private Brands brands;

    public SizeChart(String idSizeChart, double us, double uk, String eu, char type, Brands brands) {
        this.idSizeChart = idSizeChart;
        this.brands = brands;
        this.us = us;
        this.uk = uk;
        this.eu = eu;
        this.type = type;
    }

    public SizeChart() {
    }

    public String getIdSizeChart() {
        return idSizeChart;
    }

    public void setIdSizeChart(String idSizeChart) {
        this.idSizeChart = idSizeChart;
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
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
}
