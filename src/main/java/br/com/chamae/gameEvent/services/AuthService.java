package br.com.chamae.gameEvent.services;

import br.com.chamae.gameEvent.requests.AuthRequest;
import br.com.chamae.gameEvent.responses.AuthResponse;

public interface AuthService {
	AuthResponse login(AuthRequest request) throws Exception;
}
