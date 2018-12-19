package com.erp.application.service.mapper;

import com.erp.application.domain.*;
import com.erp.application.service.dto.AppUserDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AppUser and its DTO AppUserDTO.
 */
@Mapper(componentModel = "spring", uses = {PreferenceMapper.class, ErpMapper.class})
public interface AppUserMapper extends EntityMapper<AppUserDTO, AppUser> {

    @Mapping(source = "preference.id", target = "preferenceId")
    @Mapping(source = "erp.id", target = "erpId")
    AppUserDTO toDto(AppUser appUser);

    @Mapping(source = "preferenceId", target = "preference")
    @Mapping(source = "erpId", target = "erp")
    AppUser toEntity(AppUserDTO appUserDTO);

    default AppUser fromId(Long id) {
        if (id == null) {
            return null;
        }
        AppUser appUser = new AppUser();
        appUser.setId(id);
        return appUser;
    }
}
