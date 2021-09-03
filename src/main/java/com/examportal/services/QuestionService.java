package com.examportal.services;

import java.util.Set;

import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;


public interface QuestionService {
	
	
	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getQuestions();
	
	public Question getQuestion(Long qnid);
	
	public void deleteQuestion(Long qid);
	
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
}
