package com.techwave.ProductService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.ProductService.Entity.Product;
import com.techwave.ProductService.Service.IProduct;

@RestController
public class ProductController {
	@Autowired
	IProduct productService;

	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		return productService.getAllProducts();
	}

	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@GetMapping("/getProductById/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	@PutMapping("/updateProductById/{id}")
	public ResponseEntity<Product> updateProductById(@RequestBody Product product, @PathVariable int id){
		return productService.updateProductById(product,id);
	}
	@DeleteMapping("deleteProductById/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable int id){
		return productService.deleteProductById(id);
	}
}
