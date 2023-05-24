package com.app.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.modal.Product;
import com.app.service.ProductService;

@Controller
@RequestMapping(path = "emp")
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping(path = "show")
	public String showPages(Model m) {
		m.addAttribute("msg", "Welcome App:" + new Date());
		return "Home";
	}

	@PostMapping(path="reg")
	public String showReg(Model map) {
		map.addAttribute("product", new Product());
		return "Register";
	}

	@PostMapping(value = "save")
	public String saveData(@ModelAttribute Product product, Model map) {
		Integer id = service.saveProduct(product);
		map.addAttribute("message", "Product'" + id + "'created!!");
		map.addAttribute("product", new Product());
		return "Register";
	}

	@PostMapping(path = "all")
	public String showAll(Model map) {
		List<Product> allProduct = service.getAllProducts();
		map.addAttribute("list", allProduct);
		return "Data";

	}

	@PostMapping(value = "edit")
	public String showEdit(@RequestParam Integer id, Model map) {
		Optional<Product> p = service.getProductById(id);
		map.addAttribute("product", p);
		map.addAttribute("Mode", "EDIT");
		return "Register";
	}
}
