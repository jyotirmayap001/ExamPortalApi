package com.examportal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.model.exam.Category;
import com.examportal.services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	//Add Category
	@PostMapping("/addCategory")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		
		return ResponseEntity.ok(this.categoryService.addCategory(category));
	}
	
	//Get Category
	@GetMapping("/getCategory/{catid}")
	public ResponseEntity<Category> getCategory(@PathVariable("catid") Long catid){
		
		return ResponseEntity.ok(this.categoryService.getCategory(catid));
	}
	
	//Get All Category
	@GetMapping("/getAllCategory")
	public ResponseEntity<Set<Category>> getAllCategory(){
		
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	//Update Category
	@PutMapping("/updateCategory")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category){
		
		return ResponseEntity.ok(this.categoryService.updateCategory(category));
	}
	
	
	//Update Category
	@DeleteMapping("/deleteCategory/{catid}")
	public void deleteCategory(@PathVariable("catid") Long catid){
		
		this.categoryService.deleteCategory(catid);
	}
}
