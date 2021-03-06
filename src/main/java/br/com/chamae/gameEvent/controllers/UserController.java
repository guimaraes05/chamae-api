package br.com.chamae.gameEvent.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chamae.gameEvent.models.User;
import br.com.chamae.gameEvent.requests.AuthRequest;
import br.com.chamae.gameEvent.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping(value = "/user")
	public User createUser(@Valid @RequestBody User user) {
		return service.createUser(user);
	}
}
