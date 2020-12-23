package org.sid.controller;

import java.util.List;

import org.sid.beans.Article;
import org.sid.beans.Utilisateur;
import org.sid.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UtilisateurControler {
	@Autowired
	private UtilisateurService utilisateurService;
	
	//visualiser les jury
	@RequestMapping(value="/jury",method=RequestMethod.GET)
	public List<Utilisateur> getJury() {
		return utilisateurService.getJury();
	}
}
