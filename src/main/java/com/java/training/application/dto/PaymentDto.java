package com.java.training.application.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PaymentDto {

    @NotBlank(message = "id is incorrect")
    private String id;
}
