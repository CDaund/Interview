package com.test.competitiveexam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.competitiveexam.model.EnglishQuestions;

@Repository
public interface EnglishQuestionsRepository extends CrudRepository<EnglishQuestions, Integer> {
	
	EnglishQuestions findById(int ID);
	List<EnglishQuestions> findAll();
	void deleteById(int ID);
	
}
