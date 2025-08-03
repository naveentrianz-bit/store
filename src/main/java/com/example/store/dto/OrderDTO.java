package com.example.store.dto;

import com.example.store.entity.Order;
import com.example.store.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class OrderDTO {
    private Long id;
    private String description;
    private List<Long> productIds;

    public OrderDTO(Order order) {
        if (order == null) {
            this.id = null;
            this.productIds = List.of();
            return;
        }
        this.id = order.getId();
        this.description = order.getDescription();
        this.productIds = order.getProducts().stream()
                .map(Product::getId)
                .collect(Collectors.toList());
    }

}
