package com.ExamPortal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.examportal.model.exam.Category;
import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;
import com.examportal.services.QuizService;

@SpringBootTest
@AutoConfigureMockMvc
class ExamPortalApplicationTests {

	@MockBean
	private QuizService quizService;
	
	@Autowired
	MockMvc mockmvc;
	
	Set<Question> questions;
	
	Question question=new Question();
	
	Quiz quiz=new Quiz();
	
	Category category=new Category();
	
	
	@BeforeEach
	public void getQuestions() {
		
		this.category=new Category("Test Category","Test Description");
		this.category.setCid(1L);
		this.quiz=new Quiz("Test","Test Description","100","100",true);
		this.quiz.setQid(1L);
		this.quiz.setCategory(this.category);
		
		this.question.setQnuid(1L);
		this.question.setContent("What is Functional Interface ?");
		this.question.setAnswer("Having one abstract method");
		this.question.setOption1("Having one abstract method");
		this.question.setOption2("Having two or more abstract method");
		this.question.setOption3("Having one or more abstract method");
		this.question.setOption4("Having two abstract method");
		this.question.setImage("default.png");
		this.question.setQuiz(this.quiz);
		
		this.questions.add(this.question);
	}
	
	@AfterEach
	public void setAfterAll() {
		
		this.questions=null;
		this.question=null;
		
	}

	@Test
	public void testGetQuestions() throws Exception {
		when(this.quizService.getQuiz(1L).getQuestions()).thenReturn(this.questions);
		
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/question/quiz/1");
		ResultActions result=this.mockmvc.perform(request);
		MvcResult andReturn = result.andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status=response.getStatus();
		
		assertEquals(200, status);
	}
}
