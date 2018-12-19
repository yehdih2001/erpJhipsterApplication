package com.erp.application.service.impl;

import com.erp.application.service.ProductCountService;
import com.erp.application.domain.ProductCount;
import com.erp.application.repository.ProductCountRepository;
import com.erp.application.repository.search.ProductCountSearchRepository;
import com.erp.application.service.dto.ProductCountDTO;
import com.erp.application.service.mapper.ProductCountMapper;
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
 * Service Implementation for managing ProductCount.
 */
@Service
@Transactional
public class ProductCountServiceImpl implements ProductCountService {

    private final Logger log = LoggerFactory.getLogger(ProductCountServiceImpl.class);

    private final ProductCountRepository productCountRepository;

    private final ProductCountMapper productCountMapper;

    private final ProductCountSearchRepository productCountSearchRepository;

    public ProductCountServiceImpl(ProductCountRepository productCountRepository, ProductCountMapper productCountMapper, ProductCountSearchRepository productCountSearchRepository) {
        this.productCountRepository = productCountRepository;
        this.productCountMapper = productCountMapper;
        this.productCountSearchRepository = productCountSearchRepository;
    }

    /**
     * Save a productCount.
     *
     * @param productCountDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProductCountDTO save(ProductCountDTO productCountDTO) {
        log.debug("Request to save ProductCount : {}", productCountDTO);

        ProductCount productCount = productCountMapper.toEntity(productCountDTO);
        productCount = productCountRepository.save(productCount);
        ProductCountDTO result = productCountMapper.toDto(productCount);
        productCountSearchRepository.save(productCount);
        return result;
    }

    /**
     * Get all the productCounts.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductCountDTO> findAll() {
        log.debug("Request to get all ProductCounts");
        return productCountRepository.findAll().stream()
            .map(productCountMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one productCount by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProductCountDTO> findOne(Long id) {
        log.debug("Request to get ProductCount : {}", id);
        return productCountRepository.findById(id)
            .map(productCountMapper::toDto);
    }

    /**
     * Delete the productCount by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProductCount : {}", id);
        productCountRepository.deleteById(id);
        productCountSearchRepository.deleteById(id);
    }

    /**
     * Search for the productCount corresponding to the query.
     *
     * @param query the query of the search
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductCountDTO> search(String query) {
        log.debug("Request to search ProductCounts for query {}", query);
        return StreamSupport
            .stream(productCountSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(productCountMapper::toDto)
            .collect(Collectors.toList());
    }
}
