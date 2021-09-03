package com.examportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.model.Product;
import com.examportal.services.Impl.ProductDao;

@RestController
@RequestMapping("/product")
public class ProductControllerFoRedis {

	@Autowired
	private ProductDao product;
	
	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		
		return this.product.save(product);
	}
	
	@GetMapping("/get")
	public List<Product> getAllProduct() {
		
		return this.product.findAll();
	}
	
}
