package com.elasticrating.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Model of rating.")
public class Rating {
    private String id;

    @ApiModelProperty(notes="Id of the thing rated.")
    private String idControl;

    @ApiModelProperty(notes="Name of thing rated.")
    private String nameControl;

    @ApiModelProperty(notes="Rating.")
    private int rating;

    @ApiModelProperty(notes="Type of rating.")
    private String type;

    @ApiModelProperty(notes="Description of rating.")
    private String description;

    @ApiModelProperty(notes="Status of rating.")
    private boolean status;
}