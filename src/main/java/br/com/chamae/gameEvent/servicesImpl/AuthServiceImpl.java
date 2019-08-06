package br.com.chamae.gameEvent.servicesImpl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.chamae.gameEvent.requests.AuthRequest;
import br.com.chamae.gameEvent.responses.AuthResponse;
import br.com.chamae.gameEvent.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService{
	
	private static final String CHAMAE_CLIENT_ID = "chamae-client";
	
	private static final String DB_URL = "http://localhost:8080/oauth/token";
	
	@Autowired
    @Qualifier("login-client-rest-template")
    private RestTemplate restTemplate;
	
	@Override
	public AuthResponse login(AuthRequest request) throws Exception {
		final String user = request.getUser();
		final String password = request.getPassword();
		
		if (user == null || password == null) {
			throw new InvalidGrantException("BAD CREDENTIALS");
		}
		
		MultiValueMap<String, String> params = buildParams(user, password);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<?> entity = new HttpEntity<>(params, headers);
		
		try {
			ResponseEntity<OAuth2AccessToken> exchange = restTemplate.exchange(DB_URL, HttpMethod.POST, entity, OAuth2AccessToken.class);
			final String tokenValue = exchange.getBody().getValue();
			return new AuthResponse(tokenValue);
		} catch (Exception e) {
			throw new Exception(e);
		}
		
	}

	private MultiValueMap<String, String> buildParams(final String user, final String password) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", user);
        params.add("password", password);
        params.add("grant_type", "password");
        params.add("client_id", CHAMAE_CLIENT_ID);
		return params;
	}

}
