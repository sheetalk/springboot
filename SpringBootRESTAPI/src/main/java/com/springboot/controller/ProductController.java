package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Product;
import com.springboot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired 
	private ProductService prodService;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		List<Product> res =  prodService.getAllProducts();
		return res;
	}
	
	@GetMapping("/products/{Id}")
	public Product getProductId(@PathVariable("Id") Long id) {
		return prodService.getProductId(id);
	}
	
	@PostMapping("/products")
	public String saveProduct(@RequestBody Product prod) {
		return prodService.saveProduct(prod);
	}
	
	@PutMapping("/products/{Id}") 
	public String updateProduct(@PathVariable("Id") Long id, @RequestBody Product prod) {
		return prodService.updateProduct(id, prod);
	}
	
	@DeleteMapping("products/{Id}")
	public String deleteProduct(@PathVariable("Id") Long id) {
		return prodService.deleteProduct(id);
	}
}
