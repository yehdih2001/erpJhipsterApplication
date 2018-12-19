package com.erp.application.service.impl;

import com.erp.application.service.CompagnyService;
import com.erp.application.domain.Compagny;
import com.erp.application.repository.CompagnyRepository;
import com.erp.application.repository.search.CompagnySearchRepository;
import com.erp.application.service.dto.CompagnyDTO;
import com.erp.application.service.mapper.CompagnyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Compagny.
 */
@Service
@Transactional
public class CompagnyServiceImpl implements CompagnyService {

    private final Logger log = LoggerFactory.getLogger(CompagnyServiceImpl.class);

    private final CompagnyRepository compagnyRepository;

    private final CompagnyMapper compagnyMapper;

    private final CompagnySearchRepository compagnySearchRepository;

    public CompagnyServiceImpl(CompagnyRepository compagnyRepository, CompagnyMapper compagnyMapper, CompagnySearchRepository compagnySearchRepository) {
        this.compagnyRepository = compagnyRepository;
        this.compagnyMapper = compagnyMapper;
        this.compagnySearchRepository = compagnySearchRepository;
    }

    /**
     * Save a compagny.
     *
     * @param compagnyDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public CompagnyDTO save(CompagnyDTO compagnyDTO) {
        log.debug("Request to save Compagny : {}", compagnyDTO);

        Compagny compagny = compagnyMapper.toEntity(compagnyDTO);
        compagny = compagnyRepository.save(compagny);
        CompagnyDTO result = compagnyMapper.toDto(compagny);
        compagnySearchRepository.save(compagny);
        return result;
    }

    /**
     * Get all the compagnies.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CompagnyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Compagnies");
        return compagnyRepository.findAll(pageable)
            .map(compagnyMapper::toDto);
    }


    /**
     * Get one compagny by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CompagnyDTO> findOne(Long id) {
        log.debug("Request to get Compagny : {}", id);
        return compagnyRepository.findById(id)
            .map(compagnyMapper::toDto);
    }

    /**
     * Delete the compagny by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Compagny : {}", id);
        compagnyRepository.deleteById(id);
        compagnySearchRepository.deleteById(id);
    }

    /**
     * Search for the compagny corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CompagnyDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Compagnies for query {}", query);
        return compagnySearchRepository.search(queryStringQuery(query), pageable)
            .map(compagnyMapper::toDto);
    }
}
