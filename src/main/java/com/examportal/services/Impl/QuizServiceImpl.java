package com.examportal.services.Impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.model.exam.Quiz;
import com.examportal.repo.QuizRepository;
import com.examportal.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepo;
	
	
	@Override
	public Quiz addQuiz(Quiz quiz) {

		return this.quizRepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return this.quizRepo.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		
		return this.quizRepo.findAll().stream().sorted((i1,i2)-> -new Long(i1.getQid()).compareTo(new Long(i2.getQid()))).collect(Collectors.toSet());
	}

	@Override
	public Quiz getQuiz(Long qid) {

		return this.quizRepo.findById(qid).get();
	}

	@Override
	public void deleteQuiz(Long qid) {
		
		Quiz quiz=new Quiz();
		quiz.setQid(qid);
		
		this.quizRepo.delete(quiz);

	}

}
