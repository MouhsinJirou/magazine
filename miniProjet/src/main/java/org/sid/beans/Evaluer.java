package org.sid.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Evaluer {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEvaluer;
	
	@JsonIgnore
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	
	@JsonIgnore
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur;
	
	private String etat; // accepte-modifier-refus
	private String commentaire; // commentaire du jury
	
	
	public Evaluer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evaluer(Long idEvaluer, String etat, String commentaire) {
		super();
		this.idEvaluer = idEvaluer;
		this.etat = etat;
		this.commentaire = commentaire;
	}
	
	public Evaluer(String etat, String commentaire) {
		super();
		this.etat = etat;
		this.commentaire = commentaire;
	}

	public Evaluer(Article article, Utilisateur utilisateur) {
		super();
		this.article = article;
		this.utilisateur = utilisateur;
	}

	public Long getIdEvaluer() {
		return idEvaluer;
	}
	public void setIdEvaluer(Long idEvaluer) {
		this.idEvaluer = idEvaluer;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
}
