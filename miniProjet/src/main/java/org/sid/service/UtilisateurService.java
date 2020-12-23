package org.sid.service;

import java.util.List;

import org.sid.beans.Utilisateur;
import org.sid.dao.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	//visualiser les jury
	public List<Utilisateur> getJury(){
		return utilisateurRepository.getJury();
	}
}
