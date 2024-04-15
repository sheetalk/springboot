package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

}
