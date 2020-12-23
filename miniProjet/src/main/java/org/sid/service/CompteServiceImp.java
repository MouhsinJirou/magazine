package org.sid.service;

import org.sid.beans.Role;
import org.sid.beans.Utilisateur;
import org.sid.dao.RoleRepository;
import org.sid.dao.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompteServiceImp implements CompteService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncorder;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Utilisateur saveUser(Utilisateur user) {
		String hashPW=bCryptPasswordEncorder.encode(user.getPassword());
		user.setPassword(hashPW);;
		return utilisateurRepository.save(user);
		
	}

	@Override
	public Role saveRole(Role role) {
		
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		Role role=roleRepository.getRoleByNomRole(roleName);
		Utilisateur user=utilisateurRepository.getUserByUsername(username);
		user.setRole(role);
		utilisateurRepository.save(user);
	}

	@Override
	public Utilisateur findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return utilisateurRepository.getUserByUsername(username);
	}
}
