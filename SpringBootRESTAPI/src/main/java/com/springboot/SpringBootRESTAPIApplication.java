package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.springboot.model.Product;
import com.springboot.repository.ProductRepository;

@SpringBootApplication
@EnableCaching
public class SpringBootRESTAPIApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository prodRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRESTAPIApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		prodRepository.save(new Product("Television", "Electronic"));
		prodRepository.save(new Product("Air Conditioner", "Electonic"));
		prodRepository.save(new Product("Sofa", "Furniture"));
		prodRepository.save(new Product("Cushions", "Home Essentials"));
	}
}
