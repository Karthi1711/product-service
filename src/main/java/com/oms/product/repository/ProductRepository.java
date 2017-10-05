package com.oms.product.repository;

import com.oms.product.model.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends MongoRepository<ProductEntity,String>{

    public List<ProductEntity> findByProductDisplayName(String Name);
}
