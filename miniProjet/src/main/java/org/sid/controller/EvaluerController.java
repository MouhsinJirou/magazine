package org.sid.controller;

import java.util.List;

import org.sid.beans.Article;

import org.sid.beans.Evaluer;
import org.sid.service.EvaluerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EvaluerController {

	@Autowired
	private EvaluerService evaluerService;
	
	//affecter un article à 3 jury
	@RequestMapping(value="/affectations/{idArticle}/{idJury1}/{idJury2}/{idJury3}",method=RequestMethod.POST)
	public boolean affecterJury(@PathVariable Long idArticle,@PathVariable Long idJury1,@PathVariable Long idJury2,@PathVariable Long idJury3) {
		return evaluerService.affecterJury(idArticle, idJury1, idJury2, idJury3);
	}
	
	//afficher les articles affectés à un jury
	@RequestMapping(value="/articlejury/{id}",method=RequestMethod.GET)
	public List<Article> articleJury(@PathVariable Long id){
		return evaluerService.getArticleJury(id);
	}
	
	//mis à jour d'une evaluation
	//Demarche :
	//Quand le jury s'authentifie et choisie un article pour l'evaluer
	//on recupere depuis le Frontend son id et l'id de l'article
	//on les envoie dans la requete ci-dessous(getIdEvaluer) qui va nous
	//recuperer l'id de EVALUER,apres on va juste mettre à jour l'instance
	//par le rapport du jury (etat+commentaire)
	@RequestMapping(value="/evaluations/{id}",method=RequestMethod.PUT)
	public Evaluer updateEvaluations(@PathVariable Long id,@RequestBody Evaluer evaluer){
		evaluer.setIdEvaluer(id);; 
		return evaluerService.save(evaluer);	 	 
	}
	
	//recuperer l'id de l'evaluation selon idArticle et idJury
	@RequestMapping(value="/evaluationsid/{idArticle}/{idUtilisateur}",method=RequestMethod.GET)
	public Long getIdEvaluer(@PathVariable Long idArticle,@PathVariable Long idUtilisateur){
		return evaluerService.getIdEvaluer(idArticle, idUtilisateur);
	}
}
