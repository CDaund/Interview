package com.test.competitiveexam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.competitiveexam.model.Registration;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
	
	Registration findById(int ID);
	List<Registration> findAll();
	void deleteById(int ID);

}
