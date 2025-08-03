
package com.example.store.controller;

import com.example.store.dto.ProductDTO;
import com.example.store.entity.Product;
import com.example.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller that handles CRUD operations for products.
 * Products can be associated with one or more orders. Each product includes
 * its own ID, description, and a list of order IDs that reference it.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;

    /**
     * GET /products
     * Retrieves a list of all products in the system. Each product includes its ID,
     * description, and a list of associated order IDs.
     *
     * @return a list of ProductDTOs
     */
    @Cacheable("product")
    @GetMapping
    public List<ProductDTO> getAll() {
        return productRepo.findAll().stream()
                .map(ProductDTO::from)
                .collect(Collectors.toList());
    }

    /**
     * GET /products/{id}
     * Retrieves a specific product by its ID. The response includes product details
     * and the list of order IDs that include this product.
     *
     * @param id the ID of the product to retrieve
     */
    @Cacheable("product")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
        return productRepo.findById(id)
                .map(ProductDTO::from)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /products
     * Creates a new product with the given description.t
     *
     * @param product the product entity to create
     * @return the created Product object
     */
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepo.save(product);
    }
}
