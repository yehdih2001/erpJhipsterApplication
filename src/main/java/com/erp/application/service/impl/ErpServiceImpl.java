package com.erp.application.service.impl;

import com.erp.application.service.ErpService;
import com.erp.application.domain.Erp;
import com.erp.application.repository.ErpRepository;
import com.erp.application.repository.search.ErpSearchRepository;
import com.erp.application.service.dto.ErpDTO;
import com.erp.application.service.mapper.ErpMapper;
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
 * Service Implementation for managing Erp.
 */
@Service
@Transactional
public class ErpServiceImpl implements ErpService {

    private final Logger log = LoggerFactory.getLogger(ErpServiceImpl.class);

    private final ErpRepository erpRepository;

    private final ErpMapper erpMapper;

    private final ErpSearchRepository erpSearchRepository;

    public ErpServiceImpl(ErpRepository erpRepository, ErpMapper erpMapper, ErpSearchRepository erpSearchRepository) {
        this.erpRepository = erpRepository;
        this.erpMapper = erpMapper;
        this.erpSearchRepository = erpSearchRepository;
    }

    /**
     * Save a erp.
     *
     * @param erpDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ErpDTO save(ErpDTO erpDTO) {
        log.debug("Request to save Erp : {}", erpDTO);

        Erp erp = erpMapper.toEntity(erpDTO);
        erp = erpRepository.save(erp);
        ErpDTO result = erpMapper.toDto(erp);
        erpSearchRepository.save(erp);
        return result;
    }

    /**
     * Get all the erps.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ErpDTO> findAll() {
        log.debug("Request to get all Erps");
        return erpRepository.findAll().stream()
            .map(erpMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one erp by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ErpDTO> findOne(Long id) {
        log.debug("Request to get Erp : {}", id);
        return erpRepository.findById(id)
            .map(erpMapper::toDto);
    }

    /**
     * Delete the erp by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Erp : {}", id);
        erpRepository.deleteById(id);
        erpSearchRepository.deleteById(id);
    }

    /**
     * Search for the erp corresponding to the query.
     *
     * @param query the query of the search
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ErpDTO> search(String query) {
        log.debug("Request to search Erps for query {}", query);
        return StreamSupport
            .stream(erpSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(erpMapper::toDto)
            .collect(Collectors.toList());
    }
}
