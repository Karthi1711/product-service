package com.oms.product.model;


public class PackingInfo {
    private Double weight;
    private Dimensions dimensions;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensionsDTO(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
}
