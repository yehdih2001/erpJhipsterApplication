package com.erp.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.erp.application.service.ProductInventoryViewService;
import com.erp.application.web.rest.errors.BadRequestAlertException;
import com.erp.application.web.rest.util.HeaderUtil;
import com.erp.application.service.dto.ProductInventoryViewDTO;
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
 * REST controller for managing ProductInventoryView.
 */
@RestController
@RequestMapping("/api")
public class ProductInventoryViewResource {

    private final Logger log = LoggerFactory.getLogger(ProductInventoryViewResource.class);

    private static final String ENTITY_NAME = "erpJhipsterApplicationProductInventoryView";

    private final ProductInventoryViewService productInventoryViewService;

    public ProductInventoryViewResource(ProductInventoryViewService productInventoryViewService) {
        this.productInventoryViewService = productInventoryViewService;
    }

    /**
     * POST  /product-inventory-views : Create a new productInventoryView.
     *
     * @param productInventoryViewDTO the productInventoryViewDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new productInventoryViewDTO, or with status 400 (Bad Request) if the productInventoryView has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/product-inventory-views")
    @Timed
    public ResponseEntity<ProductInventoryViewDTO> createProductInventoryView(@RequestBody ProductInventoryViewDTO productInventoryViewDTO) throws URISyntaxException {
        log.debug("REST request to save ProductInventoryView : {}", productInventoryViewDTO);
        if (productInventoryViewDTO.getId() != null) {
            throw new BadRequestAlertException("A new productInventoryView cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProductInventoryViewDTO result = productInventoryViewService.save(productInventoryViewDTO);
        return ResponseEntity.created(new URI("/api/product-inventory-views/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /product-inventory-views : Updates an existing productInventoryView.
     *
     * @param productInventoryViewDTO the productInventoryViewDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated productInventoryViewDTO,
     * or with status 400 (Bad Request) if the productInventoryViewDTO is not valid,
     * or with status 500 (Internal Server Error) if the productInventoryViewDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/product-inventory-views")
    @Timed
    public ResponseEntity<ProductInventoryViewDTO> updateProductInventoryView(@RequestBody ProductInventoryViewDTO productInventoryViewDTO) throws URISyntaxException {
        log.debug("REST request to update ProductInventoryView : {}", productInventoryViewDTO);
        if (productInventoryViewDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ProductInventoryViewDTO result = productInventoryViewService.save(productInventoryViewDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, productInventoryViewDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /product-inventory-views : get all the productInventoryViews.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of productInventoryViews in body
     */
    @GetMapping("/product-inventory-views")
    @Timed
    public List<ProductInventoryViewDTO> getAllProductInventoryViews() {
        log.debug("REST request to get all ProductInventoryViews");
        return productInventoryViewService.findAll();
    }

    /**
     * GET  /product-inventory-views/:id : get the "id" productInventoryView.
     *
     * @param id the id of the productInventoryViewDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the productInventoryViewDTO, or with status 404 (Not Found)
     */
    @GetMapping("/product-inventory-views/{id}")
    @Timed
    public ResponseEntity<ProductInventoryViewDTO> getProductInventoryView(@PathVariable Long id) {
        log.debug("REST request to get ProductInventoryView : {}", id);
        Optional<ProductInventoryViewDTO> productInventoryViewDTO = productInventoryViewService.findOne(id);
        return ResponseUtil.wrapOrNotFound(productInventoryViewDTO);
    }

    /**
     * DELETE  /product-inventory-views/:id : delete the "id" productInventoryView.
     *
     * @param id the id of the productInventoryViewDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/product-inventory-views/{id}")
    @Timed
    public ResponseEntity<Void> deleteProductInventoryView(@PathVariable Long id) {
        log.debug("REST request to delete ProductInventoryView : {}", id);
        productInventoryViewService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/product-inventory-views?query=:query : search for the productInventoryView corresponding
     * to the query.
     *
     * @param query the query of the productInventoryView search
     * @return the result of the search
     */
    @GetMapping("/_search/product-inventory-views")
    @Timed
    public List<ProductInventoryViewDTO> searchProductInventoryViews(@RequestParam String query) {
        log.debug("REST request to search ProductInventoryViews for query {}", query);
        return productInventoryViewService.search(query);
    }

}
