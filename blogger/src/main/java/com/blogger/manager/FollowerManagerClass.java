package com.blogger.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogger.entity.Follower;
import com.blogger.entity.User;
import com.blogger.repo.RepoFollower;

@Component
public class FollowerManagerClass {
	
	@Autowired
	private RepoFollower repoFollower;
	
	public void add(User userWhoIsFollower, User userWhoIsBeingFollowed) {
		if(userWhoIsBeingFollowed != null && userWhoIsFollower != null) {
			Follower user = new Follower();
			user.setFollower(userWhoIsFollower);
			user.setFollowing(userWhoIsBeingFollowed);
			repoFollower.save(user);
		}
	}

	public List<User> findFollowers(User u) {
		return repoFollower.findByFollower(u);
	}

	public List<User> findFollowing(User u) {
		return repoFollower.findByFollowing(u);
	}

	public Boolean isFollowing(User userWhoIsFollower, User userWhoIsBeingFollowed) {
		User user = repoFollower.findFollowing(userWhoIsFollower, userWhoIsBeingFollowed);
		if(user != null)
			return true;
		return false;
	}

}
