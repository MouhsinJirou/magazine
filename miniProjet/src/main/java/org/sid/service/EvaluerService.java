package org.sid.service;

import java.util.List;

import org.sid.beans.Article;
import org.sid.beans.Evaluer;
import org.sid.dao.ArticleRepository;
import org.sid.dao.EvaluerRepository;
import org.sid.dao.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluerService {
@Autowired
private ArticleRepository articleRepository; 
@Autowired
private UtilisateurRepository utilisateurRepository;
@Autowired
private EvaluerRepository evaluerRepository;

	//le comite affecte un article à 3 jury
	public boolean affecterJury(Long idArticle,Long idJury1,Long idJury2,Long idJury3) {
		Evaluer eval1=new Evaluer(articleRepository.getOne(idArticle),utilisateurRepository.getOne(idJury1));
		Evaluer eval2=new Evaluer(articleRepository.getOne(idArticle),utilisateurRepository.getOne(idJury2));
		Evaluer eval3=new Evaluer(articleRepository.getOne(idArticle),utilisateurRepository.getOne(idJury3));
		
		evaluerRepository.save(eval1);
		evaluerRepository.save(eval2);
		evaluerRepository.save(eval3);
		return true;
	}
	
	//visualiser les articles affectés à un jury
	public List<Article> getArticleJury(Long id){
		return evaluerRepository.getArticleJury(id);
	}
	
	//save d'une evaluation
	public Evaluer save(Evaluer evaluer) {
		return evaluerRepository.save(evaluer);
	}
	
	//recuperer l'id d'une evaluation
	public Long getIdEvaluer(Long idArticle,Long idUtilisateur) {
		return evaluerRepository.getIdEvaluer(idArticle, idUtilisateur);
	}
}
