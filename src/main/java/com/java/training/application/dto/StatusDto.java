package com.java.training.application.dto;

import com.java.training.application.status.StatusEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StatusDto {

    @NotBlank(message = "id is incorrect")
    private int id;

    @NotBlank(message = "status is incorrect")
    private StatusEnum status;
}
