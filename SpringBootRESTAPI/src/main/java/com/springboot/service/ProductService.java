package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.springboot.model.Product;
import com.springboot.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Cacheable("products")
	public List<Product> getAllProducts(){
		List<Product> allProduct = new ArrayList<>();
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		productRepository.findAll().forEach(allProduct::add);
		allProduct.stream().forEach(s -> System.out.println(s.toString()));
		return allProduct;
	}
	
	@Cacheable(value="product", key="#p0")
	public <Optional>Product getProductId(Long id) {
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		Product prod = productRepository.findById(id).get();
		return prod;
	}
	
	@CacheEvict(value="products", allEntries=true)
	public String saveProduct(Product prod) {
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		productRepository.save(prod);
		return "Saved";
	}
	
	@Caching (evict = {
			@CacheEvict(value="product", key="#p0"),
			@CacheEvict(value="products", allEntries=true)
	})
	public String updateProduct(Long id, Product prod) {
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		if(productRepository.findById(id).get() != null) {
			productRepository.save(prod);
			return "updated";
		} else 
			return "not updated";
	}
	
	@Caching (evict = {
			@CacheEvict(value="product", key="#p0"),
			@CacheEvict(value="products", allEntries=true)
	})
	public String deleteProduct(Long id) {
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		if(productRepository.findById(id).get() != null) {
			productRepository.deleteById(id);
			return "deleted";
		} else {
			return "Not deleted";
		}
			
	}
}
