package com.erp.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.erp.application.service.ProductReodringRulesService;
import com.erp.application.web.rest.errors.BadRequestAlertException;
import com.erp.application.web.rest.util.HeaderUtil;
import com.erp.application.service.dto.ProductReodringRulesDTO;
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
 * REST controller for managing ProductReodringRules.
 */
@RestController
@RequestMapping("/api")
public class ProductReodringRulesResource {

    private final Logger log = LoggerFactory.getLogger(ProductReodringRulesResource.class);

    private static final String ENTITY_NAME = "erpJhipsterApplicationProductReodringRules";

    private final ProductReodringRulesService productReodringRulesService;

    public ProductReodringRulesResource(ProductReodringRulesService productReodringRulesService) {
        this.productReodringRulesService = productReodringRulesService;
    }

    /**
     * POST  /product-reodring-rules : Create a new productReodringRules.
     *
     * @param productReodringRulesDTO the productReodringRulesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new productReodringRulesDTO, or with status 400 (Bad Request) if the productReodringRules has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/product-reodring-rules")
    @Timed
    public ResponseEntity<ProductReodringRulesDTO> createProductReodringRules(@Valid @RequestBody ProductReodringRulesDTO productReodringRulesDTO) throws URISyntaxException {
        log.debug("REST request to save ProductReodringRules : {}", productReodringRulesDTO);
        if (productReodringRulesDTO.getId() != null) {
            throw new BadRequestAlertException("A new productReodringRules cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProductReodringRulesDTO result = productReodringRulesService.save(productReodringRulesDTO);
        return ResponseEntity.created(new URI("/api/product-reodring-rules/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /product-reodring-rules : Updates an existing productReodringRules.
     *
     * @param productReodringRulesDTO the productReodringRulesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated productReodringRulesDTO,
     * or with status 400 (Bad Request) if the productReodringRulesDTO is not valid,
     * or with status 500 (Internal Server Error) if the productReodringRulesDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/product-reodring-rules")
    @Timed
    public ResponseEntity<ProductReodringRulesDTO> updateProductReodringRules(@Valid @RequestBody ProductReodringRulesDTO productReodringRulesDTO) throws URISyntaxException {
        log.debug("REST request to update ProductReodringRules : {}", productReodringRulesDTO);
        if (productReodringRulesDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ProductReodringRulesDTO result = productReodringRulesService.save(productReodringRulesDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, productReodringRulesDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /product-reodring-rules : get all the productReodringRules.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of productReodringRules in body
     */
    @GetMapping("/product-reodring-rules")
    @Timed
    public List<ProductReodringRulesDTO> getAllProductReodringRules() {
        log.debug("REST request to get all ProductReodringRules");
        return productReodringRulesService.findAll();
    }

    /**
     * GET  /product-reodring-rules/:id : get the "id" productReodringRules.
     *
     * @param id the id of the productReodringRulesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the productReodringRulesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/product-reodring-rules/{id}")
    @Timed
    public ResponseEntity<ProductReodringRulesDTO> getProductReodringRules(@PathVariable Long id) {
        log.debug("REST request to get ProductReodringRules : {}", id);
        Optional<ProductReodringRulesDTO> productReodringRulesDTO = productReodringRulesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(productReodringRulesDTO);
    }

    /**
     * DELETE  /product-reodring-rules/:id : delete the "id" productReodringRules.
     *
     * @param id the id of the productReodringRulesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/product-reodring-rules/{id}")
    @Timed
    public ResponseEntity<Void> deleteProductReodringRules(@PathVariable Long id) {
        log.debug("REST request to delete ProductReodringRules : {}", id);
        productReodringRulesService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/product-reodring-rules?query=:query : search for the productReodringRules corresponding
     * to the query.
     *
     * @param query the query of the productReodringRules search
     * @return the result of the search
     */
    @GetMapping("/_search/product-reodring-rules")
    @Timed
    public List<ProductReodringRulesDTO> searchProductReodringRules(@RequestParam String query) {
        log.debug("REST request to search ProductReodringRules for query {}", query);
        return productReodringRulesService.search(query);
    }

}
