package com.scaleset.search.es.filter;

import static org.elasticsearch.index.query.FilterBuilders.notFilter;

import org.elasticsearch.index.query.FilterBuilder;

import com.scaleset.search.Filter;
import com.scaleset.search.es.ESFilterBuilderConverter;
public class NotFilterConverter implements FilterConverter {

	@Override
	public FilterBuilder convert(Filter filter) {
		Filter f = (Filter)filter.get("filter");
		FilterBuilder fbuilder = ESFilterBuilderConverter.convert(f);
		return notFilter(fbuilder);
	}

}

