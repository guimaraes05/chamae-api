package br.com.chamae.gameEvent.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.chamae.gameEvent.models.User;

public interface UserRepository extends MongoRepository<User, Integer> {

  boolean existsByUsername(String username);

  User findByUsername(String username);

  void deleteByUsername(String username);

}