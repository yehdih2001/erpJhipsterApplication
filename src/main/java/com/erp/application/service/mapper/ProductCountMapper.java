package com.erp.application.service.mapper;

import com.erp.application.domain.*;
import com.erp.application.service.dto.ProductCountDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ProductCount and its DTO ProductCountDTO.
 */
@Mapper(componentModel = "spring", uses = {ProductInventoryViewMapper.class})
public interface ProductCountMapper extends EntityMapper<ProductCountDTO, ProductCount> {

    @Mapping(source = "product.id", target = "productId")
    ProductCountDTO toDto(ProductCount productCount);

    @Mapping(source = "productId", target = "product")
    ProductCount toEntity(ProductCountDTO productCountDTO);

    default ProductCount fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProductCount productCount = new ProductCount();
        productCount.setId(id);
        return productCount;
    }
}
