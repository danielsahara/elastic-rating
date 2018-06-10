package com.elasticrating.controller;

import com.elasticrating.model.Rating;
import com.elasticrating.service.RatingServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {
    @Autowired
    private RatingServiceImpl ratingService;

    @GetMapping(value = "/ratings")
    @ApiOperation(value = "Find rating",
            notes = "Find rating via parameter")
    public List<Rating> list(@RequestParam(value = "idControl", required = false) String idControl,
                             @RequestParam(value = "rating", required = false) String rating,
                             @RequestParam(value = "type", required = false) String type,
                             @RequestParam(value = "description", required = false) String description) {

        return ratingService.list(idControl, rating, type, description);
    }

    @PostMapping(value = "/ratings")
    public void create(@RequestBody Rating rating) {
        ratingService.save(rating);
    }

    @PatchMapping(value = "/ratings")
    public void update(@RequestBody Rating rating) {
        ratingService.update(rating);
    }
}
