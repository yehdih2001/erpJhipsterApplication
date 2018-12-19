package com.erp.application.service;

import com.erp.application.service.dto.ProductInventoryViewDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing ProductInventoryView.
 */
public interface ProductInventoryViewService {

    /**
     * Save a productInventoryView.
     *
     * @param productInventoryViewDTO the entity to save
     * @return the persisted entity
     */
    ProductInventoryViewDTO save(ProductInventoryViewDTO productInventoryViewDTO);

    /**
     * Get all the productInventoryViews.
     *
     * @return the list of entities
     */
    List<ProductInventoryViewDTO> findAll();


    /**
     * Get the "id" productInventoryView.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ProductInventoryViewDTO> findOne(Long id);

    /**
     * Delete the "id" productInventoryView.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

    /**
     * Search for the productInventoryView corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @return the list of entities
     */
    List<ProductInventoryViewDTO> search(String query);
}
