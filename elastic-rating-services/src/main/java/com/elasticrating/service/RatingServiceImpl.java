package com.elasticrating.service;

import com.elasticrating.model.Rating;
import com.elasticrating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> list(String idControl, String rating, String type, String description, Integer from, Integer size){
        return ratingRepository.findAll(idControl, rating, type, description, from , size);
    }

    public void save(Rating rating){
        ratingRepository.save(rating);
    }

    public void update(Rating productRating) {
        ratingRepository.update(productRating);
    }
}
