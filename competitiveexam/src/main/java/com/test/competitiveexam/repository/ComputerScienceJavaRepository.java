package com.test.competitiveexam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.competitiveexam.model.ComputerScienceJavaQuestions;

@Repository
public interface ComputerScienceJavaRepository extends CrudRepository<ComputerScienceJavaQuestions, Integer> {

	ComputerScienceJavaQuestions findById(int ID);
	List<ComputerScienceJavaQuestions> findAll();
	void deleteById(int ID);
}
