package com.erp.application.service.mapper;

import com.erp.application.domain.*;
import com.erp.application.service.dto.ErpDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Erp and its DTO ErpDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ErpMapper extends EntityMapper<ErpDTO, Erp> {


    @Mapping(target = "compagnies", ignore = true)
    @Mapping(target = "users", ignore = true)
    Erp toEntity(ErpDTO erpDTO);

    default Erp fromId(Long id) {
        if (id == null) {
            return null;
        }
        Erp erp = new Erp();
        erp.setId(id);
        return erp;
    }
}
