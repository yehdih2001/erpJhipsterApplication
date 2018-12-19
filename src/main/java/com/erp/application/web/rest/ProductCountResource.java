package com.erp.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.erp.application.service.ProductCountService;
import com.erp.application.web.rest.errors.BadRequestAlertException;
import com.erp.application.web.rest.util.HeaderUtil;
import com.erp.application.service.dto.ProductCountDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing ProductCount.
 */
@RestController
@RequestMapping("/api")
public class ProductCountResource {

    private final Logger log = LoggerFactory.getLogger(ProductCountResource.class);

    private static final String ENTITY_NAME = "erpJhipsterApplicationProductCount";

    private final ProductCountService productCountService;

    public ProductCountResource(ProductCountService productCountService) {
        this.productCountService = productCountService;
    }

    /**
     * POST  /product-counts : Create a new productCount.
     *
     * @param productCountDTO the productCountDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new productCountDTO, or with status 400 (Bad Request) if the productCount has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/product-counts")
    @Timed
    public ResponseEntity<ProductCountDTO> createProductCount(@RequestBody ProductCountDTO productCountDTO) throws URISyntaxException {
        log.debug("REST request to save ProductCount : {}", productCountDTO);
        if (productCountDTO.getId() != null) {
            throw new BadRequestAlertException("A new productCount cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProductCountDTO result = productCountService.save(productCountDTO);
        return ResponseEntity.created(new URI("/api/product-counts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /product-counts : Updates an existing productCount.
     *
     * @param productCountDTO the productCountDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated productCountDTO,
     * or with status 400 (Bad Request) if the productCountDTO is not valid,
     * or with status 500 (Internal Server Error) if the productCountDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/product-counts")
    @Timed
    public ResponseEntity<ProductCountDTO> updateProductCount(@RequestBody ProductCountDTO productCountDTO) throws URISyntaxException {
        log.debug("REST request to update ProductCount : {}", productCountDTO);
        if (productCountDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ProductCountDTO result = productCountService.save(productCountDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, productCountDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /product-counts : get all the productCounts.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of productCounts in body
     */
    @GetMapping("/product-counts")
    @Timed
    public List<ProductCountDTO> getAllProductCounts() {
        log.debug("REST request to get all ProductCounts");
        return productCountService.findAll();
    }

    /**
     * GET  /product-counts/:id : get the "id" productCount.
     *
     * @param id the id of the productCountDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the productCountDTO, or with status 404 (Not Found)
     */
    @GetMapping("/product-counts/{id}")
    @Timed
    public ResponseEntity<ProductCountDTO> getProductCount(@PathVariable Long id) {
        log.debug("REST request to get ProductCount : {}", id);
        Optional<ProductCountDTO> productCountDTO = productCountService.findOne(id);
        return ResponseUtil.wrapOrNotFound(productCountDTO);
    }

    /**
     * DELETE  /product-counts/:id : delete the "id" productCount.
     *
     * @param id the id of the productCountDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/product-counts/{id}")
    @Timed
    public ResponseEntity<Void> deleteProductCount(@PathVariable Long id) {
        log.debug("REST request to delete ProductCount : {}", id);
        productCountService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/product-counts?query=:query : search for the productCount corresponding
     * to the query.
     *
     * @param query the query of the productCount search
     * @return the result of the search
     */
    @GetMapping("/_search/product-counts")
    @Timed
    public List<ProductCountDTO> searchProductCounts(@RequestParam String query) {
        log.debug("REST request to search ProductCounts for query {}", query);
        return productCountService.search(query);
    }

}
