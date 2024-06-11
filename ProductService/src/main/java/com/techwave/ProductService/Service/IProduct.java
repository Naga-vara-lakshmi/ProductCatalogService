package com.techwave.ProductService.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.techwave.ProductService.Entity.Product;

public interface IProduct {
	public ResponseEntity<List<Product>> getAllProducts();

	public ResponseEntity<Product> addProduct(Product product);

	public ResponseEntity<Product> getProductById(int id);

	public ResponseEntity<Product> updateProductById(Product product, int id);

	public ResponseEntity<String> deleteProductById(int id);
	

}
