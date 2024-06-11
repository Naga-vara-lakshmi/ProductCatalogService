package com.techwave.ProductService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techwave.ProductService.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
