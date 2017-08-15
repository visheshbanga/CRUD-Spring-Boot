package com.blogger.request;

import org.springframework.beans.factory.annotation.Autowired;

public class SearchRequest {
	@Autowired
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
