/**
 * 
 */
package com.chandan.labs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.chandan.labs.security.service.UserService;
import com.chandan.labs.security.user.User;
import com.chandan.labs.security.web.config.SecurityUser;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		User user = userService.findUserByEmail(userName);
		if(user == null){
			throw new UsernameNotFoundException("UserName "+userName+" not found");
		}
		return new SecurityUser(user);
	}

}
