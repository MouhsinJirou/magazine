package org.sid.beans;

import java.util.HashSet;
import java.util.Set;

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
public class MotCle {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMotCle;
	private String motCle;
	
	@JsonIgnore 
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article; //chaque article a des mots cle

	public MotCle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MotCle(Long idMotCle, String motCle) {
		super();
		this.idMotCle = idMotCle;
		this.motCle = motCle;
	}

	public MotCle(String motCle) {
		super();
		this.motCle = motCle;
	}

	public Long getIdMotCle() {
		return idMotCle;
	}

	public void setIdMotCle(Long idMotCle) {
		this.idMotCle = idMotCle;
	}

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
}
