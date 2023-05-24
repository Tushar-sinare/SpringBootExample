package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Product;
@Service
public interface ProductService {
	public Integer saveProduct(Product p);
	public List<Product> getAllProducts();
	public void deleteProduct(Integer id);
	public Product getProductById(Integer id);
}
