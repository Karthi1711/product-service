package com.oms.product.model;


import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class PackingInfo {

    @DecimalMin(value = "1.00", message = "Packing Weight must be higher than {value} kg")
    @DecimalMax(value = "50.00", message = "Packing Weight must be lower than {value} kg")
    private Double weight;

    @Valid
    @NotNull(message = "PackingInfo Dimensions can't be blank")
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

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }


}
