package org.sid.dao;

import java.util.List;

import org.sid.beans.Article;
import org.sid.beans.Evaluer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article,Long>{

	//recuperer l'état de l'etat de l'article selon son ID
	@Query("SELECT a.decisionFinal from Article a where a.idArticle=:id")
	public String etatArticle(Long id);
	
	//recuperer l'etat de chaque jury et son commentaire
	@Query("SELECT e.etat,e.commentaire from Article a join a.evaluations e where a.idArticle=:id")
	public List<Object> rapportJury(Long id);
	
	//Visualiser les articles dont l'etat="nouveau" (c'est le comité qui va les exploiter)
	@Query("SELECT a from Article a WHERE a.etat='nouveau'")
	public List<Article> getArticleNew();
	
	//retourner l'article dont l'id dans le parametre  afin de changer l'etat de 'nouveau' vers 'conforme' ou 'non conforme'
	//c'est le comité qui va faire cette démarche à partir du FRONTEND.On va appeler la meme methode PUT en lui envoyant le nouveau objet Article
	
	//On peut aussi avec cette methode modifier la valeur de decision finale vers : Accepte/refuse/modification...
	//depuis le frontend on appelant le methode PUT et lui envoyant le nouveau objet mis à jour
	@Query("SELECT a from Article a WHERE  a.idArticle=:id")
	public Article getArticleId(Long id);
	
	//Visualiser les articles dont l'etat="conforme" afin de les affecter au jury
		@Query("SELECT a from Article a WHERE a.etat='conforme'")
		public List<Article> getArticleConforme();
		
	//visualiser les evaluations d'un article selon son id
		@Query("SELECT e from Article a join a.evaluations e WHERE a.idArticle=:id")
		public List<Object> getEvaluations(Long id);
		
	
}
