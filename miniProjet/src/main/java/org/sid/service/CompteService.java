package org.sid.service;

import org.sid.beans.Role;
import org.sid.beans.Utilisateur;

public interface CompteService {

public Utilisateur saveUser(Utilisateur utilisateur);
	
	public Role saveRole(Role role);
	
	public void addRoleToUser(String username,String roleName);
	
	public Utilisateur findUserByUsername(String username);
	
}
