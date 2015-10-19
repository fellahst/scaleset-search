package com.scaleset.search.es.filter;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.OrFilterBuilder;

import com.scaleset.search.Filter;
import com.scaleset.search.es.ESFilterBuilderConverter;
public class OrFilterConverter implements FilterConverter {

	@Override
	public FilterBuilder convert(Filter filter) {
		List<Filter> filters = (List<Filter>)filter.get("filters");
		
		List<FilterBuilder> filterBuilders = new ArrayList<FilterBuilder>();
		for(Filter f: filters) {
			FilterBuilder fbuilder = ESFilterBuilderConverter.convert(f);
			filterBuilders.add(fbuilder);
		}
		OrFilterBuilder orFilterBuilder = new OrFilterBuilder();
		for(FilterBuilder fb :filterBuilders )
			orFilterBuilder.add(fb);
		return orFilterBuilder;
	}

}

