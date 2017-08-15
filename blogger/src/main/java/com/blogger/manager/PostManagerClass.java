package com.blogger.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogger.entity.Post;
import com.blogger.entity.User;
import com.blogger.repo.RepoPost;

@Component
public class PostManagerClass {

	@Autowired
	RepoPost repo;
	
	public void create(User user, String p) {
		Post post = new Post();
		post.setUserId(user);
		post.setPost(p);
		repo.save(post);
	}

	public List<Post> getPost(List<User> userList) {
		return repo.getPost(userList);
	}

}
