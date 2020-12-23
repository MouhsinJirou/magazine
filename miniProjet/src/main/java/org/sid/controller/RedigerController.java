package org.sid.controller;

import java.util.List;

import org.sid.beans.Article;
import org.sid.service.RedigerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RedigerController {
	@Autowired
	private RedigerService redigerService;
	
//INFOS REDUITES	
	@RequestMapping(value="/auteur/articlesreduit",method=RequestMethod.GET)
	public List<Object> getArticlesParAuteurReduit(@RequestParam(name="nom",defaultValue="")String nom)
			{
		return redigerService.getArticleParAuteurReduit(nom);
	}
	
	@RequestMapping(value="/motcle/articlesreduit",method=RequestMethod.GET)
	public List<Object> getArticlesParMotCleReduit(@RequestParam(name="motcle",defaultValue="")String motCle)
			{
		return redigerService.getArticleParMotCleReduit(motCle);
	}
	
//INFOS COMPLETES
	@RequestMapping(value="/auteur/articles",method=RequestMethod.GET)
	public List<Object> getArticlesParAuteur(@RequestParam(name="nom",defaultValue="")String nom)
			{
		return redigerService.getArticleParAuteur(nom);
	}
	
	@RequestMapping(value="/motcle/articles",method=RequestMethod.GET)
	public List<Object> getArticlesParMotCle(@RequestParam(name="motcle",defaultValue="")String motCle)
			{
		return redigerService.getArticleParMotCle(motCle);
	}
}
