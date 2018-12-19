package com.erp.application.repository.search;

import com.erp.application.domain.ProductReodringRules;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the ProductReodringRules entity.
 */
public interface ProductReodringRulesSearchRepository extends ElasticsearchRepository<ProductReodringRules, Long> {
}
