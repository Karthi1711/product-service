package com.oms.product.model.domain;


import com.oms.product.model.PackingInfo;
import com.oms.product.model.Specifications;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class ProductDTO {

    private String id;

    @NotBlank(message = "Product name can't be blank")
    @Size(min = 5, max = 15)
    private String productDisplayName;

    @NotBlank(message = "Product description can't be blank")
    @Size(min = 10, max = 25)
    private String description;

    @DecimalMin(value = "1.00", message = "Price must be higher than ${value}")
    @DecimalMax(value = "99999.999", message = "Price must be lower than ${value}")
    private Double price;

    @Valid
    @NotNull(message = "Product PackingInfo can't be blank")
    private PackingInfo packingInfo;

    @Valid
    @NotNull(message = "Product Specifications can't be blank")
    private Specifications specifications;

    private Date createdDate;
    private Date lastModifiedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductDisplayName() {
        return productDisplayName;
    }

    public void setProductDisplayName(String productDisplayName) {
        this.productDisplayName = productDisplayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PackingInfo getPackingInfo() {
        return packingInfo;
    }

    public void setPackingInfo(PackingInfo packingInfo) {
        this.packingInfo = packingInfo;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }


}
