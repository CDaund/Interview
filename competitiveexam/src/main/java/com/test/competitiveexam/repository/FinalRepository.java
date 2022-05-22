package com.test.competitiveexam.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.test.competitiveexam.model.Final;

@Repository
public interface FinalRepository 
	extends CrudRepository<Final, Integer> {
	
	Final findById(int ID);
	List<Final> findAll();
	void deleteById(int ID);
}
