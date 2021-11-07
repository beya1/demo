package com.example.demo.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.entites.Role;
import com.example.demo.entites.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {
	
	@Autowired
	IUserService us;

	@Test
	@Order(1)
	public void testRetrieveAllUsers() {
	List<User> listUsers = us.retrieveAllUsers();
	Assertions.assertEquals(0,listUsers.size());
	}
	
	@Test
	@Order(2)
	public void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		User u = new User ("beya", "beya", d, Role.INGENIEUR);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
	}
	
		
	@Test
	@Order(3)
	public void testUpdateUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-15");
		User u = new User (1L, "hariz","hariz", d, Role.INGENIEUR);
		User userUpdated = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userUpdated.getLastName());
		
		
	}
	
	@Test
	@Order(4)
	public void testRetriveUser() {
		User userRetrived = us.retrieveUser("1");
		Assertions.assertEquals(1,userRetrived.getId());
		
	}
	
	//@Test
	//@Order(5)
	//public void testDeleteUser() {
		//us.deleteUser("19");
		//Assertions.assertNull(us.retrieveUser("20"));
		
	//}
	
	
	
}