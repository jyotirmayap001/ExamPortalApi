package com.examportal.model.exam;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Quiz {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long qid; 
	
	private String title;
	
	private String description;
	
	private String maxmarks;
	
	private String numberofquestion;
	
	private boolean active=false;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Category category;
	
	@OneToMany(mappedBy="quiz",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Question> questions=new LinkedHashSet<>();
	
	public Quiz() {}

	public Quiz(String title, String description, String maxmarks, String numberofquestion, boolean active) {
		super();
		this.title = title;
		this.description = description;
		this.maxmarks = maxmarks;
		this.numberofquestion = numberofquestion;
		this.active = active;
	}

	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaxmarks() {
		return maxmarks;
	}

	public void setMaxmarks(String maxmarks) {
		this.maxmarks = maxmarks;
	}

	public String getNumberofquestion() {
		return numberofquestion;
	}

	public void setNumberofquestion(String numberofquestion) {
		this.numberofquestion = numberofquestion;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	
	 

}
