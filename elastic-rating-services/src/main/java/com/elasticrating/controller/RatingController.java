package com.elasticrating.controller;

import com.elasticrating.model.Rating;
import com.elasticrating.service.RatingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class RatingController {
    @Autowired
    private RatingService ratingService;


    @ApiOperation(value = "Search rating.",
            notes = "Search rating.",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @GetMapping(value = "/ratings")
    public List<Rating> list(@RequestParam(value = "idControl", required = false) String idControl,
                             @RequestParam(value = "rating", required = false) String rating,
                             @RequestParam(value = "type", required = false) String type,
                             @RequestParam(value = "description", required = false) String description,
                             @RequestParam(value = "from", required = false) Integer from,
                             @RequestParam(value = "size", required = false) Integer size) {

        return ratingService.list(idControl, rating, type, description, from, size);
    }

    @ApiOperation(value = "Save rating",
            notes = "Save rating",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PostMapping(value = "/ratings")
    public void create(@RequestBody Rating rating) {
        ratingService.save(rating);
    }

    @ApiOperation(value = "Update a rating",
            notes = "Update a rating",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @PatchMapping(value = "/ratings")
    public void update(@RequestBody Rating rating) {
        ratingService.update(rating);
    }
}
