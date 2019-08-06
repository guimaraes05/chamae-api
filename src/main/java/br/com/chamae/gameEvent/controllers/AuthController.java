package br.com.chamae.gameEvent.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.chamae.gameEvent.requests.AuthRequest;
import br.com.chamae.gameEvent.responses.AuthResponse;
import br.com.chamae.gameEvent.services.AuthService;

@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping(value = "/login")
	public AuthResponse login(@Valid @RequestBody AuthRequest request) throws Exception {
		return authService.login(request);
	}
}
