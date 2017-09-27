package com.oms.product.service;


import com.oms.product.model.request.ProductRequest;
import com.oms.product.model.response.ProductResponse;

public interface ProductService {
    public ProductResponse addProduct(ProductRequest productRequest);
    public ProductResponse getProduct (String id);
    public void cancelProduct (String id);
    public ProductResponse searchAllProducts();


}
