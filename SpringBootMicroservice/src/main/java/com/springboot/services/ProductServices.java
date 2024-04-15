package com.springboot.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.springboot.model.Product;

@Service
public class ProductServices {
	
	List<Product> product = new ArrayList<>(Arrays.asList(
		new Product("P01", "Test1", "AAAAAAAA"),
		new Product("P02", "Test2", "BBBBBBBB"),
		new Product("P03", "Test3", "CCCCCCCC"),
		new Product("P04", "Test4", "DDDDDDDD")
	));
	
	public List<Product> getProducts(){
		return product;
	}
	
	public Product getProductId(String id) {
		return product.stream().filter(i -> i.getId().equals(id)).findFirst().get();
	}
	
	public String addProduct(Product prod) {
		 product.add(prod);
		 return "Saved";
	}
	
	public String updateProduct(String id, Product prod) {
		AtomicInteger j = new AtomicInteger(0);
		String status[] = new String[1];
		product.forEach(i -> {
			if(j.get() < product.size()) {
				if(i.getId().equals(id)) {
					product.set(j.get(), prod);
					status[0] = "Updated";
				}
			}
			j.getAndIncrement();
		});
		if(status[0].equals("Updated")) {
			return "Updated";
		} else {
			return "";
		}
	}
}
