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
public class Rediger {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idRediger;
	
	@JsonIgnore
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	
	@JsonIgnore
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur utilisateur; //l'auteur qui ca rediger / co-auteur

	
	public Rediger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rediger(Long idRediger, Article article, Utilisateur utilisateur) {
		super();
		this.idRediger = idRediger;
		this.article = article;
		this.utilisateur = utilisateur;
	}

	public Rediger(Article article, Utilisateur utilisateur) {
		super();
		this.article = article;
		this.utilisateur = utilisateur;
	}

	public Long getIdRediger() {
		return idRediger;
	}

	public void setIdRediger(Long idRediger) {
		this.idRediger = idRediger;
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
	
	
}
