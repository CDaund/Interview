package com.test.competitiveexam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.competitiveexam.model.AdminRegistration;

@Repository
public interface AdminRepository 
	extends CrudRepository<AdminRegistration, Integer> {
	
	AdminRepository findById(int ID);
	List<AdminRegistration> findAll();
	void deleteById(int ID);

}
