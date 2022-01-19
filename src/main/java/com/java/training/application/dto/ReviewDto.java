package com.java.training.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReviewDto {

    @NotBlank(message = "id is incorrect")
    private String id;
}
