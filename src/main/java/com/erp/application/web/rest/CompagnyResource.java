package com.erp.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.erp.application.service.CompagnyService;
import com.erp.application.web.rest.errors.BadRequestAlertException;
import com.erp.application.web.rest.util.HeaderUtil;
import com.erp.application.web.rest.util.PaginationUtil;
import com.erp.application.service.dto.CompagnyDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
 * REST controller for managing Compagny.
 */
@RestController
@RequestMapping("/api")
public class CompagnyResource {

    private final Logger log = LoggerFactory.getLogger(CompagnyResource.class);

    private static final String ENTITY_NAME = "erpJhipsterApplicationCompagny";

    private final CompagnyService compagnyService;

    public CompagnyResource(CompagnyService compagnyService) {
        this.compagnyService = compagnyService;
    }

    /**
     * POST  /compagnies : Create a new compagny.
     *
     * @param compagnyDTO the compagnyDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new compagnyDTO, or with status 400 (Bad Request) if the compagny has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/compagnies")
    @Timed
    public ResponseEntity<CompagnyDTO> createCompagny(@Valid @RequestBody CompagnyDTO compagnyDTO) throws URISyntaxException {
        log.debug("REST request to save Compagny : {}", compagnyDTO);
        if (compagnyDTO.getId() != null) {
            throw new BadRequestAlertException("A new compagny cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CompagnyDTO result = compagnyService.save(compagnyDTO);
        return ResponseEntity.created(new URI("/api/compagnies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /compagnies : Updates an existing compagny.
     *
     * @param compagnyDTO the compagnyDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated compagnyDTO,
     * or with status 400 (Bad Request) if the compagnyDTO is not valid,
     * or with status 500 (Internal Server Error) if the compagnyDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/compagnies")
    @Timed
    public ResponseEntity<CompagnyDTO> updateCompagny(@Valid @RequestBody CompagnyDTO compagnyDTO) throws URISyntaxException {
        log.debug("REST request to update Compagny : {}", compagnyDTO);
        if (compagnyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CompagnyDTO result = compagnyService.save(compagnyDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, compagnyDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /compagnies : get all the compagnies.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of compagnies in body
     */
    @GetMapping("/compagnies")
    @Timed
    public ResponseEntity<List<CompagnyDTO>> getAllCompagnies(Pageable pageable) {
        log.debug("REST request to get a page of Compagnies");
        Page<CompagnyDTO> page = compagnyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/compagnies");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /compagnies/:id : get the "id" compagny.
     *
     * @param id the id of the compagnyDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the compagnyDTO, or with status 404 (Not Found)
     */
    @GetMapping("/compagnies/{id}")
    @Timed
    public ResponseEntity<CompagnyDTO> getCompagny(@PathVariable Long id) {
        log.debug("REST request to get Compagny : {}", id);
        Optional<CompagnyDTO> compagnyDTO = compagnyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(compagnyDTO);
    }

    /**
     * DELETE  /compagnies/:id : delete the "id" compagny.
     *
     * @param id the id of the compagnyDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/compagnies/{id}")
    @Timed
    public ResponseEntity<Void> deleteCompagny(@PathVariable Long id) {
        log.debug("REST request to delete Compagny : {}", id);
        compagnyService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/compagnies?query=:query : search for the compagny corresponding
     * to the query.
     *
     * @param query the query of the compagny search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/compagnies")
    @Timed
    public ResponseEntity<List<CompagnyDTO>> searchCompagnies(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of Compagnies for query {}", query);
        Page<CompagnyDTO> page = compagnyService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/compagnies");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
