package com.erp.application.service;

import com.erp.application.service.dto.ProductReodringRulesDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing ProductReodringRules.
 */
public interface ProductReodringRulesService {

    /**
     * Save a productReodringRules.
     *
     * @param productReodringRulesDTO the entity to save
     * @return the persisted entity
     */
    ProductReodringRulesDTO save(ProductReodringRulesDTO productReodringRulesDTO);

    /**
     * Get all the productReodringRules.
     *
     * @return the list of entities
     */
    List<ProductReodringRulesDTO> findAll();


    /**
     * Get the "id" productReodringRules.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ProductReodringRulesDTO> findOne(Long id);

    /**
     * Delete the "id" productReodringRules.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the productReodringRules corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @return the list of entities
     */
    List<ProductReodringRulesDTO> search(String query);
}
