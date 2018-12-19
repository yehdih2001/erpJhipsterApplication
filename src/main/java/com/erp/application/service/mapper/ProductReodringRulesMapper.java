package com.erp.application.service.mapper;

import com.erp.application.domain.*;
import com.erp.application.service.dto.ProductReodringRulesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ProductReodringRules and its DTO ProductReodringRulesDTO.
 */
@Mapper(componentModel = "spring", uses = {ProductInventoryViewMapper.class})
public interface ProductReodringRulesMapper extends EntityMapper<ProductReodringRulesDTO, ProductReodringRules> {

    @Mapping(source = "product.id", target = "productId")
    ProductReodringRulesDTO toDto(ProductReodringRules productReodringRules);

    @Mapping(source = "productId", target = "product")
    ProductReodringRules toEntity(ProductReodringRulesDTO productReodringRulesDTO);

    default ProductReodringRules fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProductReodringRules productReodringRules = new ProductReodringRules();
        productReodringRules.setId(id);
        return productReodringRules;
    }
}
