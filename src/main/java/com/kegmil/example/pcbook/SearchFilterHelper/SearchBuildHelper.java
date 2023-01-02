package com.kegmil.example.pcbook.SearchFilterHelper;

import com.kegmil.example.pcbook.pb.Filter;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

public class SearchBuildHelper {
    public static QueryBuilder buildQueryBuilder(Filter filter) {
        BoolQueryBuilder context = QueryBuilders.boolQuery();
        context.must(QueryBuilders.rangeQuery("priceUsd").lte(filter.getMaxPriceUsd()))
                .must(QueryBuilders.rangeQuery("cpu.numberCores").gte(filter.getMinCpuCores()))
                .must(QueryBuilders.rangeQuery("cpu.minGhz").gte(filter.getMinCpuGhz()));

        return context;
    }
}
