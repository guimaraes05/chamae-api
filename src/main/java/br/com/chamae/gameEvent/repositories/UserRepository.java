package br.com.chamae.gameEvent.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.chamae.gameEvent.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}