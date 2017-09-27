package com.oms.product.service;

import com.oms.product.model.domain.ProductDTO;
import com.oms.product.model.entity.ProductEntity;
import com.oms.product.model.request.ProductRequest;
import com.oms.product.model.response.ProductResponse;
import com.oms.product.repository.ProductRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductResponse addProduct(ProductRequest productRequest) {
        ProductResponse productResponse = new ProductResponse();
        List<ProductEntity> productEntityList = new ArrayList<ProductEntity>();

        productRequest.getProducts().forEach(productDTO -> {
            productEntityList.add(domainToEntity(productDTO));
        });

        List<ProductEntity> productEntityListReturned = productRepository.insert(productEntityList);

        List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
        productEntityListReturned.forEach(productEntity -> {
            productDTOList.add(entityToDomain(productEntity));
        });
        productResponse.setProducts(productDTOList);
        return productResponse;

    }

    private ProductEntity domainToEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        if (productDTO.getCreatedDate() == null)
            productDTO.setCreatedDate(new Date());
        if (productDTO.getLastModifiedDate() == null)
            productDTO.setLastModifiedDate(new Date());
        try {
            BeanUtils.copyProperties(productEntity, productDTO);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            System.err.println(ex.getMessage());
        }
        return productEntity;
    }

    private ProductDTO entityToDomain(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        try {
            BeanUtils.copyProperties(productDTO, productEntity);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            System.err.println(ex.getMessage());
        }
        return productDTO;
    }
}
