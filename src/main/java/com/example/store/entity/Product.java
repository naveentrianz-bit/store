
package com.example.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
