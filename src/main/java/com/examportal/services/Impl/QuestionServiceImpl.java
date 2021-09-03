package com.examportal.services.Impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;
import com.examportal.repo.QuestionRepository;
import com.examportal.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepo;
	
	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepo.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {

		return this.questionRepo.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		
		return this.questionRepo.findAll().stream().sorted().collect(Collectors.toSet());
	}

	@Override
	public Question getQuestion(Long qnid) {
		
		return this.questionRepo.findById(qnid).get();
	}

	@Override
	public void deleteQuestion(Long qid) {
		
		Question question =new Question();
		
		question.setQnuid(qid);
		
		this.questionRepo.delete(question);

	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		
		return this.questionRepo.findByquiz(quiz);
	}

}
