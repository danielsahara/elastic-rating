package com.elasticrating.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Model of rating")
public class Rating {
    private String id;

    @ApiModelProperty(notes="Id of control")
    private String idControl;
    private String nameControl;
    @ApiModelProperty(notes="Rating")
    private int rating;
    private String type;
    private String description;
    private boolean status;
}