package com.erp.application.service.mapper;

import com.erp.application.domain.*;
import com.erp.application.service.dto.PreferenceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Preference and its DTO PreferenceDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PreferenceMapper extends EntityMapper<PreferenceDTO, Preference> {



    default Preference fromId(Long id) {
        if (id == null) {
            return null;
        }
        Preference preference = new Preference();
        preference.setId(id);
        return preference;
    }
}
