package com.blogger.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "createdAt", updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public User() {
	}

	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getName() {
		return this.username;
	}

	public void setName(String username) {
		this.username = username;
	}

	public Integer getId() {
		return this.id;
	}
	
	public User setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;

	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

}
