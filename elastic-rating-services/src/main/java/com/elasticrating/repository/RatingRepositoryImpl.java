package com.elasticrating.repository;

import com.elasticrating.model.Rating;
import com.google.gson.Gson;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.*;

@Repository
public class RatingRepositoryImpl implements RatingRepository{
    @Autowired
    private TransportClient client;

    @Value("${elastic.index.name}")
    private String indexName;

    @Value("${elastic.index.type}")
    private String indexType;

    public List<Rating> findAll(String idControl, String rating, String type, String description, Integer from, Integer size) {
        BoolQueryBuilder queryBuilder = boolQuery();

        if(idControl != null) queryBuilder.must(termQuery("idControl", idControl));
        if(rating != null) queryBuilder.must(termQuery("rating", rating));
        if(type != null) queryBuilder.must(termQuery("type", type));
        if(description != null) queryBuilder.must(matchQuery("description", description));

        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(indexName)
                .setTypes(indexType)
                .setQuery(queryBuilder);

        if(from != null ) searchRequestBuilder.setFrom(from);
        if(size != null ) searchRequestBuilder.setSize(size);

        SearchResponse response =searchRequestBuilder.execute().actionGet();

        List<Rating> ratings = new ArrayList<>();

        response.getHits().forEach(hit -> {
            Rating ratingFound = new Gson().fromJson(hit.getSourceAsString(), Rating.class);
            ratingFound.setId(hit.getId());
            ratings.add(ratingFound);
            }
        );

        return ratings;
    }

    public void save(Rating rating) {
        IndexResponse response = client.prepareIndex(indexName, indexType)
                .setSource(new Gson().toJson(rating), XContentType.JSON)
                .get();
    }

    public void update(Rating rating) {
        client.prepareUpdate(indexName, indexType, rating.getId())
                .setDoc(new Gson().toJson(rating)).get();

    }
}
