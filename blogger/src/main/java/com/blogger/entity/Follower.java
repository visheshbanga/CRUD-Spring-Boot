package com.blogger.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "followers")
public class Follower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "follower_id")
	private User follower;
	
	@ManyToOne
	@JoinColumn(name = "following_id")
	private User following;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getFollower() {
		return follower;
	}

	public void setFollower(User follower) {
		this.follower = follower;
	}

	public User getFollowing() {
		return following;
	}

	public void setFollowing(User following) {
		this.following = following;
	}
}
