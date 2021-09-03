package com.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.model.exam.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
