package com.examportal.services;

import java.util.Set;

import com.examportal.model.exam.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizzes();
	
	public Quiz getQuiz(Long qid);
	
	public void deleteQuiz(Long qid);
	
}
