package com.erp.application.service;

import com.erp.application.service.dto.CompagnyDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Compagny.
 */
public interface CompagnyService {

    /**
     * Save a compagny.
     *
     * @param compagnyDTO the entity to save
     * @return the persisted entity
     */
    CompagnyDTO save(CompagnyDTO compagnyDTO);

    /**
     * Get all the compagnies.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<CompagnyDTO> findAll(Pageable pageable);


    /**
     * Get the "id" compagny.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<CompagnyDTO> findOne(Long id);

    /**
     * Delete the "id" compagny.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the compagny corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<CompagnyDTO> search(String query, Pageable pageable);
}
