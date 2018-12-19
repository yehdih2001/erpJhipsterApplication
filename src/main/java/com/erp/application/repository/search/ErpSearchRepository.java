package com.erp.application.repository.search;

import com.erp.application.domain.Erp;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Erp entity.
 */
public interface ErpSearchRepository extends ElasticsearchRepository<Erp, Long> {
}
