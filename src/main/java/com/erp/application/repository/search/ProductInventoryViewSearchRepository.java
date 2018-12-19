package com.erp.application.repository.search;

import com.erp.application.domain.ProductInventoryView;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the ProductInventoryView entity.
 */
public interface ProductInventoryViewSearchRepository extends ElasticsearchRepository<ProductInventoryView, Long> {
}
