package com.oms.product.model;


import org.hibernate.validator.constraints.NotBlank;

public class Specifications {

    @NotBlank(message = "Specification name can't be blank")
    private String name;

    @NotBlank(message = "Specification value can't be blank")
    private String value;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
