package com.blogger.repo;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blogger.entity.Follower;
import com.blogger.entity.User;

public interface RepoFollower extends JpaRepository<Follower, Integer> {

	@Query("Select u.follower from Follower u where u.following = :id")
	List<User> findByFollower(@Param("id") User id);

	@Query("Select u.following from Follower u where u.follower = :id")
	List<User> findByFollowing(@Param("id") User id);
	
	@Query("select u.follower from Follower u where u.follower = ?1 and u.following = ?2")
	User findFollowing(User follower, User Followed);

}
