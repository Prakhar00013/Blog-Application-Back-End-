package org.blogApp.security;

import org.blogApp.entities.User;
import org.blogApp.exceptions.UserNotFoundException;
import org.blogApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		loading user from database using username as email of user
		User user = this.userRepo.findByEmail(username).orElseThrow(()-> new UserNotFoundException("User", "Username", username));
		return user;
	}

}
