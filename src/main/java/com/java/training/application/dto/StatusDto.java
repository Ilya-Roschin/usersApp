package com.java.training.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StatusDto {

    @NotBlank(message = "id is incorrect")
    private long id;

    @NotBlank(message = "status name is incorrect")
    private String statusName;
}
