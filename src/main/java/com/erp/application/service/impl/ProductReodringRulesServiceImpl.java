package com.erp.application.service.impl;

import com.erp.application.service.ProductReodringRulesService;
import com.erp.application.domain.ProductReodringRules;
import com.erp.application.repository.ProductReodringRulesRepository;
import com.erp.application.repository.search.ProductReodringRulesSearchRepository;
import com.erp.application.service.dto.ProductReodringRulesDTO;
import com.erp.application.service.mapper.ProductReodringRulesMapper;
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
 * Service Implementation for managing ProductReodringRules.
 */
@Service
@Transactional
public class ProductReodringRulesServiceImpl implements ProductReodringRulesService {

    private final Logger log = LoggerFactory.getLogger(ProductReodringRulesServiceImpl.class);

    private final ProductReodringRulesRepository productReodringRulesRepository;

    private final ProductReodringRulesMapper productReodringRulesMapper;

    private final ProductReodringRulesSearchRepository productReodringRulesSearchRepository;

    public ProductReodringRulesServiceImpl(ProductReodringRulesRepository productReodringRulesRepository, ProductReodringRulesMapper productReodringRulesMapper, ProductReodringRulesSearchRepository productReodringRulesSearchRepository) {
        this.productReodringRulesRepository = productReodringRulesRepository;
        this.productReodringRulesMapper = productReodringRulesMapper;
        this.productReodringRulesSearchRepository = productReodringRulesSearchRepository;
    }

    /**
     * Save a productReodringRules.
     *
     * @param productReodringRulesDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProductReodringRulesDTO save(ProductReodringRulesDTO productReodringRulesDTO) {
        log.debug("Request to save ProductReodringRules : {}", productReodringRulesDTO);

        ProductReodringRules productReodringRules = productReodringRulesMapper.toEntity(productReodringRulesDTO);
        productReodringRules = productReodringRulesRepository.save(productReodringRules);
        ProductReodringRulesDTO result = productReodringRulesMapper.toDto(productReodringRules);
        productReodringRulesSearchRepository.save(productReodringRules);
        return result;
    }

    /**
     * Get all the productReodringRules.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductReodringRulesDTO> findAll() {
        log.debug("Request to get all ProductReodringRules");
        return productReodringRulesRepository.findAll().stream()
            .map(productReodringRulesMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one productReodringRules by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProductReodringRulesDTO> findOne(Long id) {
        log.debug("Request to get ProductReodringRules : {}", id);
        return productReodringRulesRepository.findById(id)
            .map(productReodringRulesMapper::toDto);
    }

    /**
     * Delete the productReodringRules by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ProductReodringRules : {}", id);
        productReodringRulesRepository.deleteById(id);
        productReodringRulesSearchRepository.deleteById(id);
    }

    /**
     * Search for the productReodringRules corresponding to the query.
     *
     * @param query the query of the search
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductReodringRulesDTO> search(String query) {
        log.debug("Request to search ProductReodringRules for query {}", query);
        return StreamSupport
            .stream(productReodringRulesSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(productReodringRulesMapper::toDto)
            .collect(Collectors.toList());
    }
}
