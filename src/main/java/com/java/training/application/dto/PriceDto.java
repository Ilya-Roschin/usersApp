package com.java.training.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class PriceDto {

    @NotBlank(message = "id is incorrect")
    private String id;

    @NotBlank(message = "value is incorrect")
    private BigDecimal value;
}
