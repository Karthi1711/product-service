package com.oms.product.model.entity;


import com.oms.product.model.PackingInfo;
import com.oms.product.model.Specifications;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "Product")
public class ProductEntity {

    @Id
    private String id;
    private String productDisplayName;
    private String description;
    private Double price;
    private PackingInfo packingInfo;
    private Specifications specifications;

    @DateTimeFormat
    private Date createdDate;

    @DateTimeFormat
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
