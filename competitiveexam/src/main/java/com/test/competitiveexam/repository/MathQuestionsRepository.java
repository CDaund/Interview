package com.test.competitiveexam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.competitiveexam.model.MathQuestions;

@Repository
public interface MathQuestionsRepository extends CrudRepository<MathQuestions, Integer> {

	MathQuestions findById(int ID);
	List<MathQuestions> findAll();
	void deleteById(int ID);
}
