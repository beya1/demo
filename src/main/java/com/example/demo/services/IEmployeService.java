package com.example.demo.services;

import java.util.List;

import com.example.demo.entites.Employe;


public interface IEmployeService { 
	 
	List<Employe> retrieveAllEmployes(); 
	Employe addEmploye(Employe e);
	void deleteEmploye(String id);
	Employe updateEmploye(Employe e);
	Employe retrieveEmploye(String id);

} 
 

 
