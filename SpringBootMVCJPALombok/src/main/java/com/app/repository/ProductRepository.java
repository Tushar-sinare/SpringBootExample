package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);

}
