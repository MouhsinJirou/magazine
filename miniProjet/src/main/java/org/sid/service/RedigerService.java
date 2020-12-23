package org.sid.service;

import java.util.List;

import org.sid.beans.Article;
import org.sid.dao.RedigerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedigerService {
@Autowired
private RedigerRepository redigerRepository;
//INFOS REDUITES
	public List<Object> getArticleParAuteurReduit(String nomAuteur){
		return redigerRepository.getArticlesParAuteurReduit(nomAuteur);
	}
	
	public List<Object> getArticleParMotCleReduit(String motCle){
		return redigerRepository.getArticlesParMotCleReduit(motCle);
	}

//INFOS COMPLETES
	public List<Object> getArticleParAuteur(String nomAuteur){
		return redigerRepository.getArticlesParAuteur(nomAuteur);
	}
	
	public List<Object> getArticleParMotCle(String motCle){
		return redigerRepository.getArticlesParMotCle(motCle);
	}
}
