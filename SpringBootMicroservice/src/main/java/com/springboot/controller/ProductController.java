package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Product;
import com.springboot.services.ProductServices;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServices prodService;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return prodService.getProducts();
	}
	
	@GetMapping("/products/{Id}") 
	public Product getProductId(@PathVariable("Id") String id) {
		return prodService.getProductId(id);
	}
	
	@PostMapping("/products") 
	public String addProduct(@RequestBody Product prod) {
		return prodService.addProduct(prod);
	}
	
	@PutMapping("/products/{Id}")
	public String updateProduct(@RequestBody Product prod, @PathVariable("Id") String id) {
		return prodService.updateProduct(id, prod);
	}
}
