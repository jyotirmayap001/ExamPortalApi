package com.examportal.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.examportal.model.Product;

@Service
public class ProductDao {

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	
	public static final String HASH_KEY="ProductData";
	
	
	
	public Product save(Product product) {
		
		//store data into Redis
		this.redisTemplate.opsForHash().put(HASH_KEY, product.getPid(), product);
		
		return product;
	}
	
	public List<Product> findAll(){
		
		return  (List<Product>) this.redisTemplate.opsForHash().entries(HASH_KEY); 
	}
	
}
