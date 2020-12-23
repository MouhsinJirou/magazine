package org.sid.service;

import java.util.List;
import java.util.Optional;

import org.sid.beans.Article;
import org.sid.beans.Evaluer;
import org.sid.beans.Rediger;
import org.sid.dao.ArticleRepository;
import org.sid.dao.RedigerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired 
	private RedigerRepository redigerRepository;
	
	public Article save(Article article) {
		return articleRepository.save(article);
	}
	
	//Ajouter un article puis ajouter les redactions
	public Article ajouterArticle(Article arti) {
		Article article = articleRepository.save(arti);
		for(Rediger red:arti.getRedactions()) {
			Rediger rediger=new Rediger();
			rediger.setArticle(arti);
			rediger.setUtilisateur(red.getUtilisateur());
			
			redigerRepository.save(rediger);
		}
		
		return article;
	}
	
	//recuperer l'etat de l'article
	public String etatArticle(Long id) {
		return articleRepository.etatArticle(id);
	}
	
	//recuperer les rapports des jury
	public List<Object> rapportJury(Long id){
		return articleRepository.rapportJury(id);
	}
	
	//Supprimer un article + condition que l'evaluation n'a pas encore commencé
	public boolean supprimerArticle(Long id) {
		Optional<Article> article =articleRepository.findById(id);
		if(article.get().getEtat().equals("nouveau")) {
			for(Rediger r : article.get().getRedactions()){
				redigerRepository.deleteById(r.getIdRediger());
			}
			articleRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
		}
	
	//Modifier un article tant que l'evaluation n'a pas commencé
	public Article modifierArticle(Article article,Long id) {
		Article a=articleRepository.findById(id).get();
		Article ar=null;
		if(a.getEtat().equals("nouveau")) {
			article.setIdArticle(id);
			 ar=articleRepository.save(article);
		}
		return ar;
		
	}
	
	////Visualiser les articles dont l'etat="nouveau"
	public List<Article> getArticleNew() {
		return articleRepository.getArticleNew();
	}

	//retourner l' articles  selon id
	public Article getArticleId(Long id) {
		return articleRepository.getArticleId(id);
	}
	
////Visualiser les articles dont l'etat="conforme"
	public List<Article> getArticleConforme() {
		return articleRepository.getArticleConforme();
	}
	
	//Visualiser les evaluations selon l'id
	public List<Object> getEvaluations(Long id){
		return articleRepository.getEvaluations(id);
	}
}

