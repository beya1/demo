package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import com.example.demo.entites.Employe;


@Repository
public interface EmployeRepository extends CrudRepository<Employe,Integer> {
	
}
