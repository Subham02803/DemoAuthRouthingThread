package com.example.DemoThread.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.DemoThread.auth.dao.UserRepository;
import com.example.DemoThread.auth.model.DBUser;
import com.example.DemoThread.auth.model.UserPrinciple;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DBUser user = userRepository.findByUserName(username);
		if(user == null)
			throw new UsernameNotFoundException(username + " not found");
		
		return new UserPrinciple(user);
	}

}
