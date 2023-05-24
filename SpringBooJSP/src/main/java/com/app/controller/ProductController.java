package com.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Product;
import com.app.service.ProductService;

@Controller
@RequestMapping("emp")
public class ProductController {

	@Autowired
	ProductService service;
	@RequestMapping("show")
	public String showPages(Model m) {
		m.addAttribute("msg","Welcome App:" + new Date()); 
		return "Home";
	}
	@RequestMapping("reg")
	public String showReg(Model map) {
		map.addAttribute("product", new Product());
		return "Register";
	}
	@RequestMapping(value="save",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Product product,Model map) {
		Integer id = service.saveProduct(product);
		map.addAttribute("message","Product'"+id+"'created!!");
		map.addAttribute("product", new Product());
		return "Register";
	}
	@RequestMapping("all")
	public String showAll(Model map) {
		List<Product> allProduct = service.getAllProducts();
		map.addAttribute("list",allProduct);
		return "Data";
		
	}
	@RequestMapping(value="edit")
	public String showEdit(@RequestParam Integer id,Model map) {
		Product p =service.getProductById(id);
		map.addAttribute("product", p);
		map.addAttribute("Mode", "EDIT");
		return "Register";
	}
}
