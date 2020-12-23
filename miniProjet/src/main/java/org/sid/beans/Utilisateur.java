package org.sid.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Utilisateur {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String username;
	private String password;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String specialite; 
	
	@NotFound(action=NotFoundAction.IGNORE)
	@OneToMany (mappedBy="utilisateur")
	@JsonIgnore
	private Set<Evaluer> evaluations=new HashSet<>();
	
	@NotFound(action=NotFoundAction.IGNORE)
	@OneToMany (mappedBy="article")
	@JsonIgnore
	private Set<Rediger> redactions=new HashSet<>();
	
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(Long idUtilisateur, String username, String password, String nom, String prenom, String adresse,
			String tel, String specialite) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.specialite = specialite;
	}

	public Utilisateur(String username, String password, String nom, String prenom, String adresse, String tel,
			String specialite) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.specialite = specialite;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Set<Evaluer> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Set<Evaluer> evaluations) {
		this.evaluations = evaluations;
	}

	public Set<Rediger> getRedactions() {
		return redactions;
	}

	public void setRedactions(Set<Rediger> redactions) {
		this.redactions = redactions;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
