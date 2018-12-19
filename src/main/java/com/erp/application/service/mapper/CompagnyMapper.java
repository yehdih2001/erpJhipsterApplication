package com.erp.application.service.mapper;

import com.erp.application.domain.*;
import com.erp.application.service.dto.CompagnyDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Compagny and its DTO CompagnyDTO.
 */
@Mapper(componentModel = "spring", uses = {ErpMapper.class})
public interface CompagnyMapper extends EntityMapper<CompagnyDTO, Compagny> {

    @Mapping(source = "erp.id", target = "erpId")
    CompagnyDTO toDto(Compagny compagny);

    @Mapping(source = "erpId", target = "erp")
    Compagny toEntity(CompagnyDTO compagnyDTO);

    default Compagny fromId(Long id) {
        if (id == null) {
            return null;
        }
        Compagny compagny = new Compagny();
        compagny.setId(id);
        return compagny;
    }
}
