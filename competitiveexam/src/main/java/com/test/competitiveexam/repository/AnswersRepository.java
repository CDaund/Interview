package com.test.competitiveexam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.competitiveexam.model.Answers;

@Repository
public interface AnswersRepository 
	extends CrudRepository<Answers, Integer>{

	Answers findById(int ID);
	List<Answers> findAll();
	void deleteById(int ID);
}
