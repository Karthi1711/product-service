package com.oms.product.service;

import com.oms.product.exception.DomainToEntityConversionFailedException;
import com.oms.product.exception.EntityToDomainConversionFailedException;
import com.oms.product.exception.ProductNotFoundException;
import com.oms.product.model.domain.ProductDTO;
import com.oms.product.model.entity.ProductEntity;
import com.oms.product.model.request.ProductRequest;
import com.oms.product.model.response.ProductResponse;
import com.oms.product.repository.ProductRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);


    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductResponse addProduct(ProductRequest productRequest) {
        ProductResponse productResponse = new ProductResponse();
        List<ProductEntity> productEntityList = convertToProductEntityList(productRequest.getProducts());

        List<ProductEntity> productEntityListReturned = productRepository.insert(productEntityList);
        productResponse.setProducts(convertToProductDtoList(productEntityListReturned));
        return productResponse;
    }

    private List<ProductEntity> convertToProductEntityList(List<ProductDTO> productDTOList) {
        List<ProductEntity> productEntityList = new ArrayList<ProductEntity>();
        productDTOList.forEach(productDTO -> {
            productEntityList.add(domainToEntity(productDTO));
        });
        return productEntityList;
    }


    public ProductResponse getProduct(String id) {
        ProductResponse productResponse = new ProductResponse();
        List<ProductDTO> products = new ArrayList<ProductDTO>();
        ProductEntity productEntity = productRepository.findOne(id);
        if (productEntity != null) {
            ProductDTO productDTO = entityToDomain(productEntity);
            products.add(productDTO);
            productResponse.setProducts(products);
        } else {
            throw new ProductNotFoundException("Product Not Found For Product Id - " + id);
        }
        return productResponse;
    }

    public void cancelProduct(String id) {
        productRepository.delete(id);
    }

    public ProductResponse searchAllProducts() {
        LOGGER.info("message={}", "searchAllProducts");
        ProductResponse productResponse = new ProductResponse();
        List<ProductEntity> productEntityListReturned = productRepository.findAll();
        productResponse.setProducts(convertToProductDtoList(productEntityListReturned));
        return productResponse;
    }


    private List<ProductDTO> convertToProductDtoList(List<ProductEntity> productEntityListReturned) {
        List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
        if (CollectionUtils.isNotEmpty(productEntityListReturned)) {
            productEntityListReturned.forEach(productEntity -> {
                productDTOList.add(entityToDomain(productEntity));
            });
        }
        return productDTOList;
    }

    public ProductResponse searchProductsByName(String name) {
        ProductResponse productResponse = new ProductResponse();
        List<ProductEntity> productEntityListReturned = productRepository.findByProductDisplayName(name);
        productResponse.setProducts(convertToProductDtoList(productEntityListReturned));
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
            LOGGER.error("message=Domain To Entity Conversion Of Product Details failed. exception={}", ex);
            throw new DomainToEntityConversionFailedException("Customer Domain To Entity Conversion Failed: " + productDTO.getProductDisplayName());
        }
        return productEntity;
    }

    private ProductDTO entityToDomain(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        try {
            BeanUtils.copyProperties(productDTO, productEntity);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            LOGGER.error("message=Entity To Domain Conversion Of Product Details failed. exception={}", ex);
            throw new EntityToDomainConversionFailedException("Customer Entity To Domain Conversion Failed: " + productEntity.getProductDisplayName());
        }
        return productDTO;
    }
}
