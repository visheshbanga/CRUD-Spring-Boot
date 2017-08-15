package com.blogger.manager;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogger.entity.User;
import com.blogger.repo.RepoUser;

@Component
public class ManagerClass {

	@Autowired
	private RepoUser repo;
	
	/**
	 * Salt variable is used to encrypt the password
	 */
	private final String salt = "encryptmypass"; 
	
	
	/**
	 * Verifies that username is available and saves it in repository
	 * @param user
	 */
	public void create(User user) {
		User u = repo.findByUsername(user.getName());
		if(u != null) {}
		else{
			String password = user.getPassword();
			password += salt;
			user.setPassword(password);
			repo.save(user);
		}
	}
	
	/**
	 * @param user
	 * @return details of user as string
	 */
	public String login(User user) {
		User u  = repo.findByUsername(user.getName());
		String password = user.getPassword() + salt;
		if(u != null && password.equals(u.getPassword())) {
			return "Welcome " + u.getName();
		}
		else {
			return "Wrong username or password";
		}
	}
	
	public List<User> search(String username) {
		return repo.findByUsernameContaining(username);
	}
	public User find(Integer id) {
		return repo.findById(id);
	}
	
}
