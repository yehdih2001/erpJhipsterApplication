package com.erp.application.service;

import com.erp.application.service.dto.PreferenceDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Preference.
 */
public interface PreferenceService {

    /**
     * Save a preference.
     *
     * @param preferenceDTO the entity to save
     * @return the persisted entity
     */
    PreferenceDTO save(PreferenceDTO preferenceDTO);

    /**
     * Get all the preferences.
     *
     * @return the list of entities
     */
    List<PreferenceDTO> findAll();


    /**
     * Get the "id" preference.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<PreferenceDTO> findOne(Long id);

    /**
     * Delete the "id" preference.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the preference corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @return the list of entities
     */
    List<PreferenceDTO> search(String query);
}
