package com.erp.application.repository.search;

import com.erp.application.domain.Compagny;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the Compagny entity.
 */
public interface CompagnySearchRepository extends ElasticsearchRepository<Compagny, Long> {
}
