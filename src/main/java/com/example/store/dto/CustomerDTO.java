package com.example.store.dto;

import com.example.store.entity.Customer;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private List<CustomerOrderDTO> orders;

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
    }
}
