package com.erp.application.service.mapper;

import com.erp.application.domain.*;
import com.erp.application.service.dto.ProductInventoryViewDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ProductInventoryView and its DTO ProductInventoryViewDTO.
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class, AppUserMapper.class})
public interface ProductInventoryViewMapper extends EntityMapper<ProductInventoryViewDTO, ProductInventoryView> {

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "responsible.id", target = "responsibleId")
    ProductInventoryViewDTO toDto(ProductInventoryView productInventoryView);

    @Mapping(source = "productId", target = "product")
    @Mapping(source = "responsibleId", target = "responsible")
    ProductInventoryView toEntity(ProductInventoryViewDTO productInventoryViewDTO);

    default ProductInventoryView fromId(Long id) {
        if (id == null) {
            return null;
        }
        ProductInventoryView productInventoryView = new ProductInventoryView();
        productInventoryView.setId(id);
        return productInventoryView;
    }
}
