package br.com.chamae.gameEvent.controllers;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chamae.gameEvent.models.GameEvent;
import br.com.chamae.gameEvent.services.DefaultUserDetailsService;
import br.com.chamae.gameEvent.services.GameEventService;

@RestController
@RequestMapping("/api/game-event")
public class GameEventController {
	
	@Autowired
	private GameEventService service;
	
	@Autowired
	private DefaultUserDetailsService userService;

	@GetMapping(value = "/all")
	public List<GameEvent> getAllGameEvents() {
		List<GameEvent> response = service.getAllGameEvents();
		return response;
	}

	@GetMapping(value = "/{id}")
	public GameEvent getGameEventById(@PathVariable("id") ObjectId id) {
		GameEvent response = service.getGameEventById(id);
		return response;
	}

	@PutMapping(value = "/{id}")
	public void modifyGameEventById(@PathVariable("id") ObjectId id, @Valid @RequestBody GameEvent gameEvent) {
		service.modifyGameEventById(id, gameEvent);
	}

	@PostMapping(value = "/")
	public GameEvent createGameEvent(@Valid @RequestBody GameEvent gameEvent) {
		GameEvent response = service.createGameEvent(gameEvent);
		return response;
	}

	@DeleteMapping(value = "/{id}")
	public void deleteGameEvent(@PathVariable ObjectId id) {
		service.deleteGameEvent(id);
	}
}