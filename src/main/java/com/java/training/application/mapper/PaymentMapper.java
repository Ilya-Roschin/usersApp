package com.java.training.application.mapper;

import com.java.training.application.dto.PaymentDto;
import com.java.training.application.entity.Payment;
import org.mapstruct.Mapper;

@Mapper
public interface PaymentMapper {

    PaymentDto toDto(Payment payment);

    Payment toEntity(PaymentDto paymentDto);
}
