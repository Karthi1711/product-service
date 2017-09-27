package com.oms.product.model.request;


import com.oms.product.model.domain.ProductDTO;

import java.util.List;

public class ProductRequest {
    private List<ProductDTO> products;

    public List<ProductDTO> getProducts() {
        return products;
    }

    public ProductRequest setProducts(List<ProductDTO> products) {
        this.products = products;
        return this;
    }
}
