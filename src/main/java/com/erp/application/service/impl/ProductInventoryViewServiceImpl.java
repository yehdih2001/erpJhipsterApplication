package com.erp.application.service.impl;

import com.erp.application.service.ProductInventoryViewService;
import com.erp.application.domain.ProductInventoryView;
import com.erp.application.repository.ProductInventoryViewRepository;
import com.erp.application.repository.search.ProductInventoryViewSearchRepository;
import com.erp.application.service.dto.ProductInventoryViewDTO;
import com.erp.application.service.mapper.ProductInventoryViewMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing ProductInventoryView.
 */
@Service
@Transactional
public class ProductInventoryViewServiceImpl implements ProductInventoryViewService {

    private final Logger log = LoggerFactory.getLogger(ProductInventoryViewServiceImpl.class);

    private final ProductInventoryViewRepository productInventoryViewRepository;

    private final ProductInventoryViewMapper productInventoryViewMapper;

    private final ProductInventoryViewSearchRepository productInventoryViewSearchRepository;

    public ProductInventoryViewServiceImpl(ProductInventoryViewRepository productInventoryViewRepository, ProductInventoryViewMapper productInventoryViewMapper, ProductInventoryViewSearchRepository productInventoryViewSearchRepository) {
        this.productInventoryViewRepository = productInventoryViewRepository;
        this.productInventoryViewMapper = productInventoryViewMapper;
        this.productInventoryViewSearchRepository = productInventoryViewSearchRepository;
    }

    /**
     * Save a productInventoryView.
     *
     * @param productInventoryViewDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProductInventoryViewDTO save(ProductInventoryViewDTO productInventoryViewDTO) {
        log.debug("Request to save ProductInventoryView : {}", productInventoryViewDTO);

        ProductInventoryView productInventoryView = productInventoryViewMapper.toEntity(productInventoryViewDTO);
        productInventoryView = productInventoryViewRepository.save(productInventoryView);
        ProductInventoryViewDTO result = productInventoryViewMapper.toDto(productInventoryView);
        productInventoryViewSearchRepository.save(productInventoryView);
        return result;
    }

    /**
     * Get all the productInventoryViews.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductInventoryViewDTO> findAll() {
        log.debug("Request to get all ProductInventoryViews");
        return productInventoryViewRepository.findAll().stream()
            .map(productInventoryViewMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one productInventoryView by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProductInventoryViewDTO> findOne(Long id) {
        log.debug("Request to get ProductInventoryView : {}", id);
        return productInventoryViewRepository.findById(id)
            .map(productInventoryViewMapper::toDto);
    }

    /**
     * Delete the productInventoryView by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProductInventoryView : {}", id);
        productInventoryViewRepository.deleteById(id);
        productInventoryViewSearchRepository.deleteById(id);
    }

    /**
     * Search for the productInventoryView corresponding to the query.
     *
     * @param query the query of the search
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductInventoryViewDTO> search(String query) {
        log.debug("Request to search ProductInventoryViews for query {}", query);
        return StreamSupport
            .stream(productInventoryViewSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(productInventoryViewMapper::toDto)
            .collect(Collectors.toList());
    }
}
