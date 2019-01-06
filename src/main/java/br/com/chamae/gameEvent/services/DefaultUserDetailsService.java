package br.com.chamae.gameEvent.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.chamae.gameEvent.models.User;
import br.com.chamae.gameEvent.repositories.UserRepository;

@Service(value = "userService")
public class DefaultUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User userPersisted = userRepository.findByUsername(userId);
		if(userPersisted == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		UserDetails user = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username(userPersisted.getUsername())
                .password(userPersisted.getPassword())
                .authorities(getAuthority())
                .build();
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
        return Collections.emptyList();
    }

}
