package com.java.training.application.dto;

import com.java.training.application.status.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    @NotBlank(message = "id is incorrect")
    private Long id;

    private List<Long> songIds;

    @NotBlank(message = "userId is incorrect")
    private Long userId;

    @NotBlank(message = "finalPrice is incorrect")
    private BigDecimal finalPrice;

    @NotBlank(message = "id is incorrect")
    private Status status;

}
