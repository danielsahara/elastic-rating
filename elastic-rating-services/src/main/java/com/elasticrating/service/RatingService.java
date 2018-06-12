package com.elasticrating.service;

import com.elasticrating.model.Rating;

import java.util.List;

public interface RatingService {
    public void save(Rating rating);

    public void update(Rating productRating);

    public List<Rating> list(String idControl, String rating, String type, String description, Integer from, Integer size);
}
