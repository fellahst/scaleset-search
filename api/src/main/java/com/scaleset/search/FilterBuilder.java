package com.scaleset.search;

import com.scaleset.search.Filter;
import com.scaleset.search.Filter.Occur;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;

public class FilterBuilder {
	
	public static Filter term(String filterName,String fieldName,String value,Occur occur) {
		Filter match = new Filter();
		match.setName(filterName);
		match.setType("term");
		match.put("field",fieldName);
		match.put("query",value);
		match.setClause(occur);
		return match;
	}
	
	public static Filter terms(String filterName,String fieldName,String[] values,Occur occur) {
		Filter match = new Filter();
		match.setName(filterName);
		match.setType("terms");
		match.put("field",fieldName);
		match.put("query",values);
		match.setClause(occur);
		return match;
	}
	
	public static Filter prefix(String filterName,String fieldName,String value,Occur occur) {
		Filter match = new Filter();
		match.setName(filterName);
		match.setType("prefix");
		match.put("field",fieldName);
		match.put("query",value);
		match.setClause(occur);
		return match;
	}
	
	
	public static Filter bbox(String geoFieldName,Envelope env) {
		Filter bbox = new Filter();
		bbox.setName(geoFieldName);
		bbox.setType("geo_bounding_box");
		bbox.put("bbox",env);
		return bbox;		
	}
	
	public static Filter withinDistance(String geoFieldName,Geometry geomRef,double distance, String unit) {
		Filter f = new Filter();
		f.setType("geo_distance");
		f.put("field", geoFieldName);
		f.put("geometry",geomRef);
		f.put("distance",distance+unit);
		return f;		
	}
}
