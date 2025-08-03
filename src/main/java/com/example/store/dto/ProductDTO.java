package com.example.store.dto;

import com.example.store.entity.Order;
import com.example.store.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDTO {
    public Long id;
    public String description;
    public List<Long> orderIds;

    public static ProductDTO from(Product p) {
        ProductDTO dto = new ProductDTO();
        dto.id = p.getId();
        dto.description = p.getDescription();
/*        dto.orderIds = p.getOrders().stream()
                .map(Order::getId)
                .collect(Collectors.toList());*/
        dto.orderIds = p.getOrders() != null
                ? p.getOrders().stream().map(Order::getId).collect(Collectors.toList())
                : List.of();
        return dto;
    }
}
