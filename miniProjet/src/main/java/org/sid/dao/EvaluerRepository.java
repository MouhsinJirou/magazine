package org.sid.dao;


import java.util.List;

import org.sid.beans.Article;
import org.sid.beans.Evaluer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EvaluerRepository extends JpaRepository<Evaluer,Long> {
	
	//visualiser les articles affectés à un jury
	//comme ça le jury va lire les articles et leurs affecter une evaluation apres
	@Query("SELECT a from Evaluer e join e.article a WHERE e.utilisateur.idUtilisateur=:id")
	public List<Article> getArticleJury(Long id);
	
	//recuprer l'id de l'evaluation selon l'id de l'article et l'id de jury
	@Query("SELECT e.idEvaluer from Evaluer e WHERE e.article.idArticle=:idArticle AND e.utilisateur.idUtilisateur=:idUtilisateur")
	public Long getIdEvaluer(Long idArticle,Long idUtilisateur);
}
