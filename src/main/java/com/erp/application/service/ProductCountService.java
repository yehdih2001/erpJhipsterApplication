package com.erp.application.service;

import com.erp.application.service.dto.ProductCountDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing ProductCount.
 */
public interface ProductCountService {

    /**
     * Save a productCount.
     *
     * @param productCountDTO the entity to save
     * @return the persisted entity
     */
    ProductCountDTO save(ProductCountDTO productCountDTO);

    /**
     * Get all the productCounts.
     *
     * @return the list of entities
     */
    List<ProductCountDTO> findAll();


    /**
     * Get the "id" productCount.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ProductCountDTO> findOne(Long id);

    /**
     * Delete the "id" productCount.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the productCount corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @return the list of entities
     */
    List<ProductCountDTO> search(String query);
}
