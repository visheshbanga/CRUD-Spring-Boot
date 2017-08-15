package com.blogger.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogger.entity.Post;
import com.blogger.entity.User;

@Repository
public interface RepoPost extends JpaRepository<Post, Integer> {

	@Query("select p.post from Post p where p.userId in (:users) order by p.createdAt desc")
	List<Post> getPost(@Param("users") List<User> userList);
	
}
