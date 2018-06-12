package com.elasticrating.repository;

import com.elasticrating.model.Rating;

import java.util.List;

public interface RatingRepository {
    public List<Rating> findAll(String idControl, String rating, String type, String description, Integer from, Integer size);

    public void save(Rating rating);

    public void update(Rating rating);
}
