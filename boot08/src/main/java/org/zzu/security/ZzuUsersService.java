package org.zzu.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zzu.persistence.MemberRepository;

import lombok.extern.java.Log;

@Service
@Log
public class ZzuUsersService implements UserDetailsService{
	
	@Autowired
	MemberRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//User sampleUser = new User(username,"{noop}1111", Arrays.asList(new SimpleGrantedAuthority("ROLE_MANAGER")));
		//return sampleUser;
		
		return
		repo.findById(username)
		.filter(m -> m != null)
		.map(m -> new ZzuSecurityUser(m)).get();
	}
}