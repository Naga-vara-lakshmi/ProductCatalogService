package com.techwave.ProductService.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techwave.ProductService.CustomException.ResourceNotFoundException;
import com.techwave.ProductService.Entity.Product;
import com.techwave.ProductService.Repository.ProductRepository;
import com.techwave.ProductService.Service.IProduct;
@Service
public class ProductServiceImpl implements IProduct{
	@Autowired
	ProductRepository productRepository;
	@Override
	public ResponseEntity<List<Product>> getAllProducts() {
		
		return ResponseEntity.ok(productRepository.findAll());
	}
	@Override
	public ResponseEntity<Product> addProduct(Product product) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(product));
	}
	@Override
	public ResponseEntity<Product> getProductById(int id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return ResponseEntity.ok(product.get());
		}
		throw new ResourceNotFoundException("Product with id:"+id+" is not present");
	}
	@Override
	public ResponseEntity<Product> updateProductById(Product product,int id) {
		Optional<Product> productFound = productRepository.findById(id);
		if(productFound.isPresent()) {
			productFound.get().setColor(product.getColor());
			productFound.get().setPrice(product.getPrice());
			productFound.get().setName(product.getName());
			return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productFound.get()));
		}
		throw new ResourceNotFoundException("Product with id:"+id+" is not present"+" for updating");
	}
	@Override
	public ResponseEntity<String> deleteProductById(int id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			productRepository.delete(product.get());
			return ResponseEntity.status(HttpStatus.OK).body("The product with id:"+id+" is successfully deleted");
		}
		throw new ResourceNotFoundException("Product with id:"+id+" is not present"+" for deleting");
	}

}
