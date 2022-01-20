package com.java.training.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class OrderDto {

    @NotBlank(message = "id is incorrect")
    private long id;

    @NotBlank(message = "final price is incorrect")
    private BigDecimal finalPrice;
}
