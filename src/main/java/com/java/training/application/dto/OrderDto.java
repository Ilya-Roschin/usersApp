package com.java.training.application.dto;

import com.java.training.application.status.Status;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class OrderDto {

    @NotBlank(message = "id is incorrect")
    private Long id;

    private Long songId;

    private Long userId;

    @NotBlank(message = "finalPrice is incorrect")
    private BigDecimal finalPrice;

    @NotBlank(message = "id is incorrect")
    private Status status;

}
