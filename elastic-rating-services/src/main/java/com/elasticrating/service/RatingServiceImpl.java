package com.elasticrating.service;

import com.elasticrating.model.Rating;
import com.elasticrating.repository.RatingRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl {
    @Autowired
    private RatingRepositoryImpl ratingRepositoryImpl;

    public List<Rating> list(String idControl, String rating, String type, String description){
        return ratingRepositoryImpl.findAll(idControl, rating, type, description);
    }

    public void save(Rating rating){
        ratingRepositoryImpl.save(rating);
    }

    public void update(Rating productRating) {
        ratingRepositoryImpl.update(productRating);
    }
}
