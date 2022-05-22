package com.test.competitiveexam.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.competitiveexam.model.SelectSubject;

@Repository
public interface SubjectRepository 
		extends CrudRepository<SelectSubject, Integer> {
	
	SelectSubject findById(int ID);
	List<SelectSubject> findAll();
	void deleteById(int ID);
	
}
