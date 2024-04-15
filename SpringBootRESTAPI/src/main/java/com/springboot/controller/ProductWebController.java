package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.model.Product;

@Controller
public class ProductWebController {
		
	@Autowired
	ProductController productCtrl;
	
	@GetMapping("/")
	public String getAllProducts(Model model) {
		List<Product> products = productCtrl.getProducts();
		products.stream().forEach(i-> System.out.println("-->	" + i));
		model.addAttribute("products", products);
		
		return "list_products";
	}
	
	@GetMapping("/new_product")
	public String addProduct(Model model) {
		Product prod = new Product();
		
		model.addAttribute("product",prod);
		
		return "new_product";
		
	}
	
	@PostMapping("/save_product")
	public String saveNewProduct(@ModelAttribute("product") Product prod) {
		productCtrl.saveProduct(prod);
		return "redirect:/";
	}
	
	@GetMapping("/update_product/{id}")
	public String updateProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product",productCtrl.getProductId(id));
		return "update_product";
	}
	
	@PostMapping("/save_update") 
	public String saveUpdateProduct(@ModelAttribute("product") Product prod) {
		productCtrl.updateProduct(prod.getId(), prod);
		return "redirect:/";
	}
	
	@GetMapping("/delete_product/{id}")
	public String deleteProduct(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", productCtrl.getProductId(id));
		return "delete_product";
	}
	
	@PostMapping("/save_prod_delete")
	public String saveProdDelete(@ModelAttribute("product") Product prod) {
		productCtrl.deleteProduct(prod.getId());
		return "redirect:/";
	}
}
