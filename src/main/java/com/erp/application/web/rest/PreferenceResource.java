package com.erp.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.erp.application.service.PreferenceService;
import com.erp.application.web.rest.errors.BadRequestAlertException;
import com.erp.application.web.rest.util.HeaderUtil;
import com.erp.application.service.dto.PreferenceDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing Preference.
 */
@RestController
@RequestMapping("/api")
public class PreferenceResource {

    private final Logger log = LoggerFactory.getLogger(PreferenceResource.class);

    private static final String ENTITY_NAME = "erpJhipsterApplicationPreference";

    private final PreferenceService preferenceService;

    public PreferenceResource(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }

    /**
     * POST  /preferences : Create a new preference.
     *
     * @param preferenceDTO the preferenceDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new preferenceDTO, or with status 400 (Bad Request) if the preference has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/preferences")
    @Timed
    public ResponseEntity<PreferenceDTO> createPreference(@Valid @RequestBody PreferenceDTO preferenceDTO) throws URISyntaxException {
        log.debug("REST request to save Preference : {}", preferenceDTO);
        if (preferenceDTO.getId() != null) {
            throw new BadRequestAlertException("A new preference cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PreferenceDTO result = preferenceService.save(preferenceDTO);
        return ResponseEntity.created(new URI("/api/preferences/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /preferences : Updates an existing preference.
     *
     * @param preferenceDTO the preferenceDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated preferenceDTO,
     * or with status 400 (Bad Request) if the preferenceDTO is not valid,
     * or with status 500 (Internal Server Error) if the preferenceDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/preferences")
    @Timed
    public ResponseEntity<PreferenceDTO> updatePreference(@Valid @RequestBody PreferenceDTO preferenceDTO) throws URISyntaxException {
        log.debug("REST request to update Preference : {}", preferenceDTO);
        if (preferenceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PreferenceDTO result = preferenceService.save(preferenceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, preferenceDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /preferences : get all the preferences.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of preferences in body
     */
    @GetMapping("/preferences")
    @Timed
    public List<PreferenceDTO> getAllPreferences() {
        log.debug("REST request to get all Preferences");
        return preferenceService.findAll();
    }

    /**
     * GET  /preferences/:id : get the "id" preference.
     *
     * @param id the id of the preferenceDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the preferenceDTO, or with status 404 (Not Found)
     */
    @GetMapping("/preferences/{id}")
    @Timed
    public ResponseEntity<PreferenceDTO> getPreference(@PathVariable Long id) {
        log.debug("REST request to get Preference : {}", id);
        Optional<PreferenceDTO> preferenceDTO = preferenceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(preferenceDTO);
    }

    /**
     * DELETE  /preferences/:id : delete the "id" preference.
     *
     * @param id the id of the preferenceDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/preferences/{id}")
    @Timed
    public ResponseEntity<Void> deletePreference(@PathVariable Long id) {
        log.debug("REST request to delete Preference : {}", id);
        preferenceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/preferences?query=:query : search for the preference corresponding
     * to the query.
     *
     * @param query the query of the preference search
     * @return the result of the search
     */
    @GetMapping("/_search/preferences")
    @Timed
    public List<PreferenceDTO> searchPreferences(@RequestParam String query) {
        log.debug("REST request to search Preferences for query {}", query);
        return preferenceService.search(query);
    }

}
