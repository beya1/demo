package com.example.demo.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.User;
import com.example.demo.repository.UserRepository;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			l.info("In Method retrieveAllUsers: "); 
			users = (List<User>) userRepository.findAll(); 
			l.debug("Connexion avec la DB OK :");
			for (User user : users) {
				l.debug("user :" + user.getLastName());   
			} 
			l.info("Out of Method retrieveAllUsers with Success");
		}catch (Exception e) {
			l.error("Out of Method retrieveAllUsers with Errors : " + e);		}

		return users;
	}


	@Override
	public User addUser(User u) {
		l.info("In Method addUser: "); 
		User u_saved = userRepository.save(u); 
		l.info("Out of Method addUser with Success");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		l.info("In of Method updateUser");
		User u_saved = userRepository.save(u); 
		l.info("Out of Method updateUser with Success");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		l.info("In of Method deleteUser");		userRepository.deleteById(Long.parseLong(id)); 
		l.info("Out of Method deleteUser with Success");
	}

	@Override
	public User retrieveUser(String id) {
		l.info("In of Method retrieveUser");		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		l.info("Out of Method retrieveUser with Success");
		return u; 
	}

}
