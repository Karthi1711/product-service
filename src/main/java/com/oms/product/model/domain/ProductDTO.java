package com.oms.product.model.domain;


import com.oms.product.model.PackingInfo;
import com.oms.product.model.Specifications;

import java.util.Date;

public class ProductDTO {

    private String id;
    private String productDisplayName;
    private String description;
    private Double price;
    private PackingInfo packingInfo;
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
