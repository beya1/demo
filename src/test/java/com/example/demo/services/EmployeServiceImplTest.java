package com.example.demo.services;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entites.Role;
import com.example.demo.entites.Employe;
import com.example.demo.services.IEmployeService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeServiceImplTest {
	
	@Autowired
	IEmployeService us;
	
	@Test
	@Order(1)
	public void testRetrieveAllEmployes() {
		List<Employe> listEmployes = us.retrieveAllEmployes();
		Assertions.assertEquals(0, listEmployes.size());
		}
	
	@Test
	@Order(2)
	public void testAddEmploye() throws ParseException {
		Employe emp = new Employe ("Beya", "Hariz", "beya.hariz@esprit.tn", "password", true, Role.INGENIEUR);
		Employe employeAdded = us.addEmploye(emp);
		Assertions.assertEquals(emp.getNom(), employeAdded.getNom());
		}
	
	@Test
	@Order(3)
	public void testModifyEmploye() throws ParseException {
		Employe emp = new Employe (1L,"Beya", "Hariz", "beya.hariz@esprit.tn", "password", false, Role.INGENIEUR);
		Employe employeUpdated = us.addEmploye(emp);
		Assertions.assertEquals(emp.getId(), employeUpdated.getId());
	}
	
	@Test
	@Order(4)
	public void testRetrieveEmploye() throws ParseException {
		Employe employeRetrieved = us.retrieveEmploye("1");
		Assertions.assertEquals(1L, employeRetrieved.getId());
	}
	
//	@Test
//	@Order(5)
//	public void testDeleteEmploye() throws ParseException {
//		us.deleteEmploye("1");
//		Assertions.assertNull(us.retrieveEmploye("1"));
//	}

}

