package org.sid.controller;

import java.util.List;
import java.util.Optional;

import org.sid.beans.Article;
import org.sid.beans.Evaluer;
import org.sid.beans.Rediger;
import org.sid.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="/articles",method=RequestMethod.POST)
	public Article ajouterArticle(@RequestBody Article article) {
		return articleService.ajouterArticle(article);
	}
	
	@RequestMapping(value="/articles/{id}",method=RequestMethod.DELETE)
	public boolean supprimerArticle(@PathVariable Long id) {
		 return articleService.supprimerArticle(id);
		
	}
	
	@RequestMapping(value="/articles/{id}",method=RequestMethod.PUT)
	public Article modifierArticle(@RequestBody Article article,@PathVariable Long id) {
		return articleService.modifierArticle(article,id);
	}
	
	//etat d'article
	@RequestMapping(value="/etatarticle/{id}",method=RequestMethod.GET)
	public String etatArticle(@PathVariable Long id){
		return articleService.etatArticle(id);
	}
	
	//rapport des jury
	@RequestMapping(value="/rapportjury/{id}",method=RequestMethod.GET)
	public List<Object> rapportJury(@PathVariable Long id){
		return articleService.rapportJury(id);
	}
	
	//Visualiser les articles dont l'etat="nouveau" (c'est le comité qui va les exploiter)
	@RequestMapping(value="/articlesnew",method=RequestMethod.GET)
	public List<Article> getArticleNew() {
		return articleService.getArticleNew();
	}
	
	//retourner l' article  selon id
	@RequestMapping(value="/articles/{id}",method=RequestMethod.GET)
	public Article getArticleId(@PathVariable Long id) {
		return articleService.getArticleId(id);
	}
	
	//Visualiser les articles dont etat='conforme' afin de les affecter au Jury
	@RequestMapping(value="/articlesconforme",method=RequestMethod.GET)
	public List<Article> getArticleConforme() {
		return articleService.getArticleConforme();
	}
	
	//Visualiser les evaluations selon l'id (c le comité qui va les visualiser afin de donner une decision final pour l'article selon les evaluations des jury
	
	@RequestMapping(value="/evaluations/{id}",method=RequestMethod.GET)
	public List<Object> getEvaluations(@PathVariable Long id) {
		return articleService.getEvaluations(id);
	}
}
