package com.oms.product.service

import com.oms.product.model.Dimensions
import com.oms.product.model.PackingInfo
import com.oms.product.model.Specifications
import com.oms.product.model.domain.ProductDTO
import com.oms.product.model.entity.ProductEntity
import com.oms.product.model.request.ProductRequest
import com.oms.product.model.response.ProductResponse
import com.oms.product.repository.ProductRepository
import spock.lang.Specification

class ProductServiceSpec extends Specification {

    ProductService subject

    ProductRepository productRepository

    def setup() {
        productRepository = Mock ProductRepository
        subject = new ProductServiceImpl(productRepository)
    }


    def 'Add product(s)'() {
        given:
        def id = 'testId'
        def productDisplayName = 'testProduct'
        def auditDateValue = new Date()
        Specifications specifications = [name: 'specName', value: 'specVal']
        Dimensions dimensions = [weight: 9.5, height: 2.5, depth: 1.5]
        PackingInfo packingInfo = [weight: 6.5, dimensions: dimensions]
        ProductDTO productReq = [productDisplayName: productDisplayName, description: 'testDescription', price: 10.50,
                                 specifications    : specifications, packingInfo: packingInfo,
                                 createdDate       : auditDateValue, lastModifiedDate: auditDateValue]
        List<ProductDTO> products = new ArrayList<ProductDTO>()
        products.add(productReq)
        ProductRequest productRequest = [products: products]

        ProductEntity productEntityResp = [id            : id, productDisplayName: productDisplayName, description: 'testDescription', price: 10.50,
                                           specifications: specifications, packingInfo: packingInfo,
                                           createdDate   : auditDateValue, lastModifiedDate: auditDateValue]
        List<ProductEntity> productEntityRespList = new ArrayList<ProductEntity>()
        productEntityRespList.add(productEntityResp)

        when:
        ProductResponse productResponse = subject.addProduct(productRequest)
        then:
        1 * productRepository.findByProductDisplayName(productDisplayName) >> null
        1 * productRepository.insert({
            it
            it[0].productDisplayName == 'testProduct'
            it[0].description == 'testDescription'
        }) >> productEntityRespList
        productResponse
    }

}
