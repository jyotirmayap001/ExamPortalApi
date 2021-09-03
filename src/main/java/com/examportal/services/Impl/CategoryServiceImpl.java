package com.examportal.services.Impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.examportal.model.User;
import com.examportal.model.exam.Category;
import com.examportal.repo.CategoryRepository;
import com.examportal.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	
	private RedisTemplate<String, Object> redisTemplate;
	
	public static final String HASH_KEY="CategoryData";
	
	@Override
	public Category addCategory(Category category) {
		
		
		return this.categoryRepo.save(category);
		
	}

	@Override
	public Category updateCategory(Category category) {
		
		 return this.categoryRepo.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		
		return this.categoryRepo.findAll().stream().sorted((i1,i2)-> -new Long(i1.getCid()).compareTo(new Long(i2.getCid()))).collect(Collectors.toSet());
		
	}

	@Override
	public Category getCategory(Long categoryId) {

		return this.categoryRepo.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		
		Category category=new Category();
		
		category.setCid(categoryId);
		
		this.categoryRepo.delete(category);

	}

}
