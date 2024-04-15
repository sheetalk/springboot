package com.springboot.Exception;

public class ProductNotFoundExeption extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundExeption(Long id) {
		super("The product with id:" + id + "cannot be found!");
	}
}
