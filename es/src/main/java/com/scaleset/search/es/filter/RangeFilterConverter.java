package com.scaleset.search.es.filter;

import static org.elasticsearch.index.query.FilterBuilders.rangeFilter;

import org.elasticsearch.index.query.FilterBuilder;

import org.elasticsearch.index.query.RangeFilterBuilder;

import com.scaleset.search.Filter;

public class RangeFilterConverter implements FilterConverter {

	@Override
	public FilterBuilder convert(Filter filter) {

		String field = filter.getName();
		RangeFilterBuilder rangeFilter = rangeFilter(field);
		Object from = filter.get("from");
		boolean include_lower = filter.getBoolean("include_lower", true);
		Object to = filter.get("to");
		boolean include_upper = filter.getBoolean("include_upper", true);

		if (from != null) {
			if (include_lower)
				rangeFilter.gte(from);
			else
				rangeFilter.gt(from);
		}
		if (to != null) {
			if (include_upper)
				rangeFilter.lte(to);
			else
				rangeFilter.lt(to);
		}

		return rangeFilter;

	}

}
