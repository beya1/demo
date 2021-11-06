package com.example.demo.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entites.Employe;
import com.example.demo.services.IEmployeService;
@SpringBootTest
public class EmployeServiceImplTest {

	@Autowired
	IEmployeService em ;

	
	@Test
	public void testRetrieveAllEmploye() {
	List<Employe> listEmploye = em.retrieveAllEmployes();
	Assertions.assertEquals(0, listEmploye.size());
	}
	
	
}

