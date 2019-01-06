package br.com.chamae.gameEvent.servicesImpl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chamae.gameEvent.models.GameEvent;
import br.com.chamae.gameEvent.models.User;
import br.com.chamae.gameEvent.repositories.UserRepository;
import br.com.chamae.gameEvent.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public User createUser(User user) {
		user.set_id(ObjectId.get());
		return repository.save(user);

	}

}
