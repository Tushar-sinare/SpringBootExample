package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.Product;
import com.app.service.ProductService;
import com.app.util.EmailUtil;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService service;
	@Autowired
	private EmailUtil util;

	@RequestMapping("reg")
	public String showReg(Model m) {
		Product p = new Product();
		m.addAttribute("product", p);
		return "Register";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveData(@ModelAttribute Product product, @RequestParam MultipartFile fileOb, Model map) {
		Integer id = service.saveProduct(product);
		util.Send(product.getEmail(), "Product Added", "HelloUser", fileOb);
		map.addAttribute("message", "Product '" + id + "' created!!");
		map.addAttribute("product", new Product());
		return "Register";
	}

	@RequestMapping("all")
	public String showAll(Model m) {
		List<Product> obs = service.getAllProducts();
		m.addAttribute("list", obs);
		return "Data";
	}

	@RequestMapping("delete")
	public String Remove(@RequestParam Integer id) {
		service.deleteProduct(id);
		return "redirect:all";

	}

	@RequestMapping("edit")
	public String showEdit(@RequestParam Integer id, Model m) {
		Product p = service.getProductById(id);
		m.addAttribute("product", p);
		m.addAttribute("Mode", "EDIT");
		return "Register";
	}

}
