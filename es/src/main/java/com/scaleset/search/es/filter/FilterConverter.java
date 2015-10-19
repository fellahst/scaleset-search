package com.scaleset.search.es.filter;

import org.elasticsearch.index.query.FilterBuilder;

import com.scaleset.search.Filter;

public interface FilterConverter {

    FilterBuilder convert(Filter filter);

    
}
