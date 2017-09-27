package com.oms.product.controller;

import com.oms.product.model.request.ProductRequest;
import com.oms.product.model.response.ProductResponse;
import com.oms.product.service.ProductService;
import com.oms.product.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ProductResponse getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @DeleteMapping("/cancel/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void cancelProduct(@PathVariable String id) {
        productService.cancelProduct(id);
    }

    @GetMapping("/searchAllProducts")
    @ResponseStatus(HttpStatus.FOUND)
    public ProductResponse searchAllProducts() {
        return productService.searchAllProducts();
    }


}
