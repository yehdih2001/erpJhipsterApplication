package com.erp.application.service;

import com.erp.application.service.dto.ErpDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Erp.
 */
public interface ErpService {

    /**
     * Save a erp.
     *
     * @param erpDTO the entity to save
     * @return the persisted entity
     */
    ErpDTO save(ErpDTO erpDTO);

    /**
     * Get all the erps.
     *
     * @return the list of entities
     */
    List<ErpDTO> findAll();


    /**
     * Get the "id" erp.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ErpDTO> findOne(Long id);

    /**
     * Delete the "id" erp.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the erp corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @return the list of entities
     */
    List<ErpDTO> search(String query);
}
