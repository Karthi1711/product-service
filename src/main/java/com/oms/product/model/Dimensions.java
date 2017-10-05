package com.oms.product.model;


import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

public class Dimensions {

    @DecimalMin(value = "1.00", message = "Packing Weight must be higher than {value} mg")
    @DecimalMax(value = "10.00", message = "Packing Weight must be lower than {value} mg")
    private Double weight;

    @DecimalMin(value = "1.00", message = "Packing Weight must be higher than {value} m")
    @DecimalMax(value = "5.00", message = "Packing Weight must be lower than {value} m")
    private Double height;

    @DecimalMin(value = "1.00", message = "Packing Weight must be higher than {value} m")
    @DecimalMax(value = "3.00", message = "Packing Weight must be lower than {value} m")
    private Double depth;


    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }
}
