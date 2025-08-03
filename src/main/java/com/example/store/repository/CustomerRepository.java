package com.example.store.repository;

import com.example.store.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface for accessing and managing {@link Customer} entities.
 * Extends {@link JpaRepository} to provide standard CRUD operations.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Finds all customers whose name contains the specified query substring,
     * This is useful for search features where partial name matches are required.
     *
     * @param query the substring to search for in customer names
     * @return a list of customers whose names contain the query
     */
    @Query("SELECT c FROM Customer c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Customer> searchByName(@Param("query") String query);

}
