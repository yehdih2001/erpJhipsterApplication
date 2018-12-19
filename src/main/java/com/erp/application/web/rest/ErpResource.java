package com.erp.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.erp.application.service.ErpService;
import com.erp.application.web.rest.errors.BadRequestAlertException;
import com.erp.application.web.rest.util.HeaderUtil;
import com.erp.application.service.dto.ErpDTO;
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
 * REST controller for managing Erp.
 */
@RestController
@RequestMapping("/api")
public class ErpResource {

    private final Logger log = LoggerFactory.getLogger(ErpResource.class);

    private static final String ENTITY_NAME = "erpJhipsterApplicationErp";

    private final ErpService erpService;

    public ErpResource(ErpService erpService) {
        this.erpService = erpService;
    }

    /**
     * POST  /erps : Create a new erp.
     *
     * @param erpDTO the erpDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new erpDTO, or with status 400 (Bad Request) if the erp has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/erps")
    @Timed
    public ResponseEntity<ErpDTO> createErp(@Valid @RequestBody ErpDTO erpDTO) throws URISyntaxException {
        log.debug("REST request to save Erp : {}", erpDTO);
        if (erpDTO.getId() != null) {
            throw new BadRequestAlertException("A new erp cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ErpDTO result = erpService.save(erpDTO);
        return ResponseEntity.created(new URI("/api/erps/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /erps : Updates an existing erp.
     *
     * @param erpDTO the erpDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated erpDTO,
     * or with status 400 (Bad Request) if the erpDTO is not valid,
     * or with status 500 (Internal Server Error) if the erpDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/erps")
    @Timed
    public ResponseEntity<ErpDTO> updateErp(@Valid @RequestBody ErpDTO erpDTO) throws URISyntaxException {
        log.debug("REST request to update Erp : {}", erpDTO);
        if (erpDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ErpDTO result = erpService.save(erpDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, erpDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /erps : get all the erps.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of erps in body
     */
    @GetMapping("/erps")
    @Timed
    public List<ErpDTO> getAllErps() {
        log.debug("REST request to get all Erps");
        return erpService.findAll();
    }

    /**
     * GET  /erps/:id : get the "id" erp.
     *
     * @param id the id of the erpDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the erpDTO, or with status 404 (Not Found)
     */
    @GetMapping("/erps/{id}")
    @Timed
    public ResponseEntity<ErpDTO> getErp(@PathVariable Long id) {
        log.debug("REST request to get Erp : {}", id);
        Optional<ErpDTO> erpDTO = erpService.findOne(id);
        return ResponseUtil.wrapOrNotFound(erpDTO);
    }

    /**
     * DELETE  /erps/:id : delete the "id" erp.
     *
     * @param id the id of the erpDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/erps/{id}")
    @Timed
    public ResponseEntity<Void> deleteErp(@PathVariable Long id) {
        log.debug("REST request to delete Erp : {}", id);
        erpService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/erps?query=:query : search for the erp corresponding
     * to the query.
     *
     * @param query the query of the erp search
     * @return the result of the search
     */
    @GetMapping("/_search/erps")
    @Timed
    public List<ErpDTO> searchErps(@RequestParam String query) {
        log.debug("REST request to search Erps for query {}", query);
        return erpService.search(query);
    }

}
