package com.test.competitiveexam.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.test.competitiveexam.model.StudentRegistration;

@Repository
public interface StudentRepository 
	extends CrudRepository<StudentRegistration, Integer>{
	
	StudentRegistration findById(int ID);
	List<StudentRegistration> findAll();
	void deleteById(int ID);
}
