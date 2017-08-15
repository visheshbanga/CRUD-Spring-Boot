package com.blogger.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blogger.entity.User;

@Repository
public interface RepoUser extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	/**
	 * Returns user containing given name
	 * 
	 * @param username
	 * @return {@link List} of {@link User}
	 */
	@Query("Select u from User u where u.username like %?1%")
	List<User> findByUsernameContaining(String username);

	User findById(Integer id);

}