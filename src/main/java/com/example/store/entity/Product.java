
package com.example.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

}
