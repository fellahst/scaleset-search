package com.scaleset.search;

import java.util.ArrayList;
import java.util.List;

import com.scaleset.search.Filter.Occur;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;

public class FilterBuilder {

	public static Filter term(String filterName, String fieldName,
			String value, Occur occur) {
		Filter match = new Filter();
		match.setName(filterName);
		match.setType("term");
		match.put("field", fieldName);
		match.put("query", value);
		match.setClause(occur);
		return match;
	}

	public static Filter terms(String filterName, String fieldName,
			String[] values, Occur occur) {
		Filter match = new Filter();
		match.setName(filterName);
		match.setType("terms");
		match.put("field", fieldName);
		match.put("query", values);
		match.setClause(occur);
		return match;
	}

	public static Filter prefix(String filterName, String fieldName,
			String value, Occur occur) {
		Filter match = new Filter();
		match.setName(filterName);
		match.setType("prefix");
		match.put("field", fieldName);
		match.put("query", value);
		match.setClause(occur);
		return match;
	}

	public static Filter bbox(String geoFieldName, Envelope env) {
		Filter bbox = new Filter();
		bbox.setName(geoFieldName);
		bbox.setType("geo_bounding_box");
		bbox.put("bbox", env);
		return bbox;
	}

	public static Filter withinDistance(String geoFieldName, Geometry geomRef,
			double distance, String unit) {
		Filter f = new Filter();
		f.setType("geo_distance");
		f.put("field", geoFieldName);
		f.put("geometry", geomRef);
		f.put("distance", distance + unit);
		return f;
	}

	public static Filter range(String fieldName, Object from, Object to,
			boolean include_lower, boolean include_upper) {
		Filter rangeFilter = new Filter();
		rangeFilter.setName(fieldName);
		rangeFilter.setType("range");
		if (from != null) {
			rangeFilter.put("from", from);
			rangeFilter.put("include_lower", include_lower);
		}
		if (to != null) {
			rangeFilter.put("to", to);
			rangeFilter.put("include_upper", include_upper);
		}
		return rangeFilter;
	}

	
	public static Filter and(List<Filter> filters) {
		if (filters==null || filters.size()<2)
			throw new RuntimeException("Invalid size for filters in AND operation");
		Filter andFilter = new Filter();
		andFilter.setType("and");
		andFilter.put("filters",filters);
		return andFilter;
		
	}
	
	public static Filter or(List<Filter> filters) {
		if (filters==null || filters.size()<2)
			throw new RuntimeException("Invalid size for filters in OR operation");
		Filter orFilter = new Filter();
		orFilter.setType("or");
		orFilter.put("filters",filters);
		return orFilter;
		
	}
	
	public static Filter not(Filter filter) {
		if (filter==null)
			throw new RuntimeException("Filter is null in NOT operation");
		Filter andFilter = new Filter();
		andFilter.setType("not");
		andFilter.put("filter",filter);
		return andFilter;
		
	}
}
