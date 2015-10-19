package com.scaleset.search.es;

import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.index.query.FilterBuilder;

import com.scaleset.search.Filter;
import com.scaleset.search.es.filter.AndFilterConverter;
import com.scaleset.search.es.filter.FilterConverter;
import com.scaleset.search.es.filter.GeoBoundingBoxFilterConverter;
import com.scaleset.search.es.filter.GeoDistanceFilterConverter;
import com.scaleset.search.es.filter.GeoPolygonFilterConverter;
import com.scaleset.search.es.filter.GeoShapeFilterConverter;
import com.scaleset.search.es.filter.NotFilterConverter;
import com.scaleset.search.es.filter.OrFilterConverter;
import com.scaleset.search.es.filter.PrefixFilterConverter;
import com.scaleset.search.es.filter.QueryFilterConverter;
import com.scaleset.search.es.filter.RangeFilterConverter;
import com.scaleset.search.es.filter.TermFilterConverter;
import com.scaleset.search.es.filter.TermsFilterConverter;
import com.scaleset.search.es.filter.TypeFilterConverter;

public class ESFilterBuilderConverter {
	private static Map<String, FilterConverter> fConverters = new HashMap<>();
	
	static {
		fConverters.put("geo_bounding_box", new GeoBoundingBoxFilterConverter());
		fConverters.put("geo_distance", new GeoDistanceFilterConverter());
		fConverters.put("geo_shape", new GeoShapeFilterConverter());
		fConverters.put("geo_polygon", new GeoPolygonFilterConverter());
		fConverters.put("query", new QueryFilterConverter());
		fConverters.put("type", new TypeFilterConverter());
		fConverters.put("prefix", new PrefixFilterConverter());
		fConverters.put("term", new TermFilterConverter());
		fConverters.put("terms", new TermsFilterConverter());
		fConverters.put("range", new RangeFilterConverter());
		fConverters.put("and", new AndFilterConverter());
		fConverters.put("or", new OrFilterConverter());
		fConverters.put("not", new NotFilterConverter());
	}

	
	public static FilterBuilder convert(Filter filter){
		String type = filter.getType();
		if (type!=null) {
			FilterConverter fconverter = fConverters.get(type);
			return  fconverter.convert(filter);
		}
		return null;
		
	}
	
	
}
