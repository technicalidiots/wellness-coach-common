//package com.dev.wellness.jwt;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.dev.wellness.entity.WellnessUser;
//import com.dev.wellness.repo.UserRepo;
//
//@Service
//public class JwtDetailsService implements UserDetailsService {
//
//	@Autowired
//	UserRepo repo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		WellnessUser user = repo.findByUserName(username);
//
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found with username : " + username);
//		}
//
//		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPass(),
//				new ArrayList<>());
//	}
//}
