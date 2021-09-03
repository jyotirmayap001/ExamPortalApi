package com.examportal.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByquiz(Quiz quiz);

}
