package org.sid.dao;


import java.util.List;

import org.sid.beans.Article;
import org.sid.beans.Rediger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RedigerRepository extends JpaRepository<Rediger,Long> {

//INFORMATIONS REDUITES	
	//les articles selon le nom d'auteur ou prenom
	@Query("SELECT r.utilisateur.nom,r.utilisateur.prenom,r.article.titre,r.article.resume,m.motCle  FROM Rediger r join r.article a join a.motscle m WHERE (r.utilisateur.nom like %:nomAuteur% or r.utilisateur.prenom like %:nomAuteur%) and r.article.decisionFinal='publie'")
	public List<Object> getArticlesParAuteurReduit(String nomAuteur);
	//les articles selon mot Cle
	@Query("SELECT r.utilisateur.nom,r.utilisateur.prenom,r.article.titre,r.article.resume,m.motCle  FROM Rediger r join r.article a join a.motscle m WHERE  :motCle like m.motCle and r.article.decisionFinal='publie' ")
	public List<Object> getArticlesParMotCleReduit(String motCle);
	
// INFORMATIONS COMPLETES
	//les articles selon le nom d'auteur ou prenom
		@Query("SELECT r.utilisateur.nom,r.utilisateur.prenom,r.article.titre,r.article.affiliations,r.article.contenu,r.article.resume,m.motCle  FROM Rediger r join r.article a join a.motscle m WHERE (r.utilisateur.nom like %:nomAuteur% or r.utilisateur.prenom like %:nomAuteur%) and r.article.decisionFinal='publie'")
		public List<Object> getArticlesParAuteur(String nomAuteur);
		//les articles selon mot Cle
		@Query("SELECT r.utilisateur.nom,r.utilisateur.prenom,r.article.titre,r.article.affiliations,r.article.contenu,r.article.resume,m.motCle  FROM Rediger r join r.article a join a.motscle m WHERE  :motCle like m.motCle and r.article.decisionFinal='publie' ")
		public List<Object> getArticlesParMotCle(String motCle);
}
