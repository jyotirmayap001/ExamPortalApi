package com.examportal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;
import com.examportal.services.QuestionService;
import com.examportal.services.QuizService;



@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	
	@PostMapping("/add-question")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question)
	{
		
		return  ResponseEntity.ok(this.questionService.addQuestion(question));
		
	}
	@PutMapping("/update-question")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question)
	{
		
		return  ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestion(@PathVariable("qid") Long qid){
		
		
		Set<Question> questions = this.quizService.getQuiz(qid).getQuestions();
		
		List list=new ArrayList(questions);
		
		if(list.size()> Integer.parseInt(this.quizService.getQuiz(qid).getNumberofquestion())) 
		{
			list=list.subList(0, Integer.parseInt(this.quizService.getQuiz(qid).getNumberofquestion())+1);
		}
		
		Collections.shuffle(list);
		
		return ResponseEntity.ok(list);
		
		
	}
	
	@GetMapping("/get-question/{qnid}")
	public ResponseEntity<?> getQuizzeById(@PathVariable("qnid") Long qnid){
		
		return ResponseEntity.ok(this.questionService.getQuestion(qnid));
	}
	
	@DeleteMapping("/delete-question/{qnid}")
	public void  deleteQuizzeById(@PathVariable("qnid") Long qnid){
		
		this.questionService.deleteQuestion(qnid);
	}
	
}
