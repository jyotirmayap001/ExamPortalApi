package com.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.model.exam.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
