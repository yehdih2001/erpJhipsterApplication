package com.erp.application.service.impl;

import com.erp.application.service.PreferenceService;
import com.erp.application.domain.Preference;
import com.erp.application.repository.PreferenceRepository;
import com.erp.application.repository.search.PreferenceSearchRepository;
import com.erp.application.service.dto.PreferenceDTO;
import com.erp.application.service.mapper.PreferenceMapper;
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
 * Service Implementation for managing Preference.
 */
@Service
@Transactional
public class PreferenceServiceImpl implements PreferenceService {

    private final Logger log = LoggerFactory.getLogger(PreferenceServiceImpl.class);

    private final PreferenceRepository preferenceRepository;

    private final PreferenceMapper preferenceMapper;

    private final PreferenceSearchRepository preferenceSearchRepository;

    public PreferenceServiceImpl(PreferenceRepository preferenceRepository, PreferenceMapper preferenceMapper, PreferenceSearchRepository preferenceSearchRepository) {
        this.preferenceRepository = preferenceRepository;
        this.preferenceMapper = preferenceMapper;
        this.preferenceSearchRepository = preferenceSearchRepository;
    }

    /**
     * Save a preference.
     *
     * @param preferenceDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PreferenceDTO save(PreferenceDTO preferenceDTO) {
        log.debug("Request to save Preference : {}", preferenceDTO);

        Preference preference = preferenceMapper.toEntity(preferenceDTO);
        preference = preferenceRepository.save(preference);
        PreferenceDTO result = preferenceMapper.toDto(preference);
        preferenceSearchRepository.save(preference);
        return result;
    }

    /**
     * Get all the preferences.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<PreferenceDTO> findAll() {
        log.debug("Request to get all Preferences");
        return preferenceRepository.findAll().stream()
            .map(preferenceMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one preference by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PreferenceDTO> findOne(Long id) {
        log.debug("Request to get Preference : {}", id);
        return preferenceRepository.findById(id)
            .map(preferenceMapper::toDto);
    }

    /**
     * Delete the preference by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Preference : {}", id);
        preferenceRepository.deleteById(id);
        preferenceSearchRepository.deleteById(id);
    }

    /**
     * Search for the preference corresponding to the query.
     *
     * @param query the query of the search
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<PreferenceDTO> search(String query) {
        log.debug("Request to search Preferences for query {}", query);
        return StreamSupport
            .stream(preferenceSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(preferenceMapper::toDto)
            .collect(Collectors.toList());
    }
}
