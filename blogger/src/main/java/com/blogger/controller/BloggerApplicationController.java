package com.blogger.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blogger.entity.Post;
import com.blogger.entity.User;
import com.blogger.request.LoginRequest;
import com.blogger.request.SearchRequest;
import com.blogger.request.SignUpRequest;
import com.blogger.request.addRequest;
import com.blogger.request.getFollowersRequest;
import com.blogger.request.newPostRequest;
import com.blogger.response.SearchResponse;
import com.blogger.service.ServiceClass;


@RestController
public class BloggerApplicationController {
	
	@Autowired
	private ServiceClass service;  
	
	
	/*public String create(@RequestParam("username") String username,
						@RequestParam("password") String password, 
						@RequestParam("email") String email) {
	service.create(new User(username,password,email));
		return "Done";
	}*/
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String create(@RequestBody SignUpRequest request) {
		User user = requestToEntity(request);
		service.create(user);
		return "done";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody LoginRequest request) {
		User user = loginRequestToEntity(request);
		return service.login(user);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public List<SearchResponse> search(@RequestBody SearchRequest request) {
		String username = request.getUsername();
		return searchEntityToResponse(service.search(username));
	}
	
	@RequestMapping(value = "/add_to_network", method = RequestMethod.POST)
	public String addToNetwork(@RequestBody addRequest request) {
		Integer follower = request.getFollower_id();
		Integer following = request.getFollowing_id();
		service.add(follower, following);
		return "done";
	}
	
	@RequestMapping(value = "/find_followers", method = RequestMethod.POST)
	public List<SearchResponse> findFollowers(@RequestBody getFollowersRequest request){
		Integer id =  request.getId();
		return searchEntityToResponse(service.findFollowers(id));
	}
	
	@RequestMapping(value = "/create_post", method = RequestMethod.POST)
	public String createPost(@RequestBody newPostRequest request) {
		Integer userId = request.getUserId();
		String post = request.getPost();
		service.createPost(userId, post);
		return "done";
	}
	
	@RequestMapping(value = "/get_post/{id}", method = RequestMethod.GET)
	public List<Post> getPost(@PathVariable Integer id){
		return service.getPost(id);
	}

	private List<SearchResponse> searchEntityToResponse(List<User> search) {
		List<SearchResponse> response = new LinkedList<>();
		for(User result : search) {
			SearchResponse r = new SearchResponse();
			r.setUsername(result.getName());
			r.setEmail(result.getEmail());
			response.add(r);
		}
		return response;
	}

	private User requestToEntity(SignUpRequest request) {
		User user = new User();
		user.setName(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		return user;
	}
	
	private User loginRequestToEntity(LoginRequest request) {
		User user = new User();
		user.setName(request.getUsername());
		user.setPassword(request.getPassword());
		return user;
	}
}
