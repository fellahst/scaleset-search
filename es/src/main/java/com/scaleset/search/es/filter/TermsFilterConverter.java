package com.scaleset.search.es.filter;

import org.elasticsearch.index.query.FilterBuilder;
import static org.elasticsearch.index.query.FilterBuilders.termsFilter;
import com.scaleset.search.Filter;

public class TermsFilterConverter implements FilterConverter {

    @Override
    public FilterBuilder convert(Filter filter) {
        boolean cache = filter.getBoolean("cache", false);

        Object q = filter.get("query");
        String field = filter.getString("field");
        FilterBuilder result = termsFilter(field,(String[])q).cache(cache);
        return result;
    }

}