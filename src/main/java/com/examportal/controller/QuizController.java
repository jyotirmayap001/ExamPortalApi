package com.examportal.controller;

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

import com.examportal.model.exam.Quiz;
import com.examportal.services.QuizService;



@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	
	@PostMapping("/add-quiz")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz)
	{
		
		return  ResponseEntity.ok(this.quizService.addQuiz(quiz));
		
	}
	@PutMapping("/update-quiz")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz)
	{
		
		return  ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	@GetMapping("/get-quiz")
	public ResponseEntity<?>  getQuizzes(){
		
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	
	@GetMapping("/get-quiz/{qid}")
	public ResponseEntity<?>  getQuizzeById(@PathVariable("qid") Long qid){
		
		return ResponseEntity.ok(this.quizService.getQuiz(qid));
	}
	
	@DeleteMapping("/delete-quiz/{qid}")
	public void  deleteQuizzeById(@PathVariable("qid") Long qid){
		
		this.quizService.deleteQuiz(qid);
	}
	
}
