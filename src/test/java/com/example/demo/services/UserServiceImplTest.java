package com.example.demo.services;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entites.User;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
 class UserServiceImplTest {
	@Autowired
	IUserService us;
	
	@Test
	public void testretRieveAllUsers() {
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(0, listUsers.size());		
	}

}
