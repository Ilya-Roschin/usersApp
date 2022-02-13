package com.java.training.application.conroller;

import com.java.training.application.dto.OrderDto;
import com.java.training.application.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }

    @GetMapping(path = "/{id}")
    public OrderDto findById(@PathVariable final long id) {
        return orderService.findById(id);
    }

    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable("id") final Long id) {
        orderService.deleteById(id);
    }

    @PostMapping
    public void save(@RequestBody final OrderDto orderDto) {
        orderService.save(orderDto);
    }
}
