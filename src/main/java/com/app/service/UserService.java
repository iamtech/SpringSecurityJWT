package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.bean.UserBean;

@Service(value = "userService")
public class UserService implements UserDetailsService{
	
	private Map<Long, UserBean> udata = new HashMap<>();

	public UserService() {
		udata.put((long) 1,new UserBean((long)1,"user1", "pw1", 26, 22000,"ADMIN"));
		udata.put((long) 2,new UserBean((long)2,"user2", "pw2", 21, 28000, "ADMIN"));
		udata.put((long) 3,new UserBean((long)3,"user3", "pw3", 23, 27000, "USER"));
		udata.put((long) 4,new UserBean((long)4,"user4", "pw4", 27, 26000, "USER"));
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserBean user = udata.get(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}
	
	private Set<SimpleGrantedAuthority> getAuthority(UserBean user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" +user.getRoles()));
		return authorities;
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
	public List<UserBean> findAll() {
		return new ArrayList<UserBean>(udata.values());
		
	}
	
	public UserBean delete(long id) {
		UserBean bdel =  udata.get(id);
		udata.remove(id);
		return bdel;
	}

	public UserBean findOne(String username) {
		return new ArrayList<UserBean>(udata.values()).stream().filter(u -> u.getUsername().equals(username)).findAny().orElse(null);
	}
	
	public UserBean findById(Long id) {
		return udata.get(id);
	}
	
	public UserBean save(UserBean user) {
		user.setId(5);
		udata.put((long) 5, user);
		return user;
	}


}
