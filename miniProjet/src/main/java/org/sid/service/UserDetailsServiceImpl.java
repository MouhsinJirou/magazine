package org.sid.service;

import java.util.ArrayList;
import java.util.Collection;

import org.sid.beans.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired 
	private CompteService compteService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Utilisateur user=compteService.findUserByUsername(username);
		if(user==null) throw new UsernameNotFoundException(username);
		
		Collection<GrantedAuthority> authoritie=new ArrayList<>();
		
		authoritie.add(new SimpleGrantedAuthority(user.getRole().getNomRole()));
		
		
		return new User(user.getUsername(),user.getPassword(),authoritie);
	}

}
