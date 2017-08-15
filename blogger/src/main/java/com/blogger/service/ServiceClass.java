package com.blogger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogger.entity.Post;
import com.blogger.entity.User;
import com.blogger.manager.FollowerManagerClass;
import com.blogger.manager.ManagerClass;
import com.blogger.manager.PostManagerClass;

@Service
public class ServiceClass {

	@Autowired
	private ManagerClass manager;
	
	@Autowired
	private FollowerManagerClass followerManager;
	
	@Autowired
	private PostManagerClass postManager;
	
	public void create(User user) {
		manager.create(user);	
	}

	public String login(User user) {
		return manager.login(user);
	}

	public List<User> search(String username) {
		return manager.search(username);
	}

	public void add(Integer follower, Integer following) {
		User userWhoIsFollower = manager.find(follower);
		User userWhoIsBeingFollowed = manager.find(following);
		Boolean isFollowing = followerManager.isFollowing(userWhoIsFollower, userWhoIsBeingFollowed);
		if(!isFollowing)
			followerManager.add(userWhoIsFollower, userWhoIsBeingFollowed);
		
	}

	public List<User> findFollowers(Integer id) {
		User u = manager.find(id);
		return followerManager.findFollowers(u);
	}

	public void createPost(Integer userId, String post) {
		User user = manager.find(userId);
		if(user != null)
			postManager.create(user, post);
	}

	public List<Post> getPost(Integer id) {
		User u = manager.find(id);
		if (u == null)
			return null;
		List<User> userList = followerManager.findFollowing(u);
		if(userList.size() > 0)
			return postManager.getPost(userList);
		else
			return null;
	}
	
}
