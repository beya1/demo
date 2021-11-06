package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Employe;
import  com.example.demo.repository.EmployeRepository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class EmployeServiceImpl implements IEmployeService {
	
	@Autowired
	EmployeRepository employeRepository;
	
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);	
	@Override
	public List<Employe> retrieveAllEmployes() { 
		List<Employe> employes = null; 
		try {
			
			l.info("In Method retrieveAllEmployes: "); 
			employes = (List<Employe>)employeRepository.findAll(); 
			l.debug("Connexion avec la DB OK :");
			for (Employe employe : employes) {
				l.debug("employe :" + employe.getNom());   
			} 
			l.info("Out of Method retrieveAllEmployes with Success");
		}catch (Exception e) {
			l.error("Out of Method retrieveAllEmployes with Errors : " + e);		}

		return employes;
	}
	@Override
	public Employe addEmploye(Employe e) {
		l.info("In Method addEmploye: "); 
		Employe e_saved = employeRepository.save(e); 
		l.info("Out of Method addEmploye with Success");
		return e_saved; 
	}
	
	@Override 
	public Employe updateEmploye(Employe e) { 
		l.info("In of Method updateEmploye");
		Employe e_saved = employeRepository.save(e); 
		l.info("Out of Method updateEmploye with Success");
		return e_saved; 
	}

	@Override
	public void deleteEmploye(int id) {
		l.info("In of Method deleteEmploye");	
		employeRepository.deleteById(id); 
		l.info("Out of Method deleteEmploye with Success");
	}

	@Override
	public Employe retrieveEmploye(int id) {
		l.info("In of Method retrieveEmploye");		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		Employe e =  employeRepository.findById(id).get(); 
		l.info("Out of Method retrieveEmploye with Success");
		return e; 
	}


}