package org.sid.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Article {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArticle;
	private String titre;
	private String affiliations;
	private String resume;
	private String contenu;
	// etat : nouveau/conforme-non Conforme
	private String etat="nouveau"; //par default un article a l'etat=nouveau
	// la decision final du comité (accepte,refuse...)
	private String decisionFinal="Non publie";
	
	@NotFound(action=NotFoundAction.IGNORE)
	@OneToMany (mappedBy="article")
	@JsonIgnore
	private Set<Evaluer> evaluations=new HashSet<>();
	
	@NotFound(action=NotFoundAction.IGNORE)
	@OneToMany (mappedBy="article")
	@JsonIgnore
	private Set<Rediger> redactions=new HashSet<>();
	
	@NotFound(action=NotFoundAction.IGNORE)
	@OneToMany (mappedBy="article",fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<MotCle> motscle=new HashSet<>();

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(Long idArticle, String titre, String affiliations, String resume, String contenu, String etat,
			String decisionFinal) {
		super();
		this.idArticle = idArticle;
		this.titre = titre;
		affiliations = affiliations;
		this.resume = resume;
		this.contenu = contenu;
		this.etat = etat;
		this.decisionFinal = decisionFinal;
	}

	public Article(String titre, String affiliations, String resume, String contenu, String etat,
			String decisionFinal) {
		super();
		this.titre = titre;
		affiliations = affiliations;
		this.resume = resume;
		this.contenu = contenu;
		this.etat = etat;
		this.decisionFinal = decisionFinal;
	}

	
	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAffiliations() {
		return affiliations;
	}

	public void setAffiliations(String affiliations) {
		affiliations = affiliations;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getDecisionFinal() {
		return decisionFinal;
	}

	public void setDecisionFinal(String decisionFinal) {
		this.decisionFinal = decisionFinal;
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

	public Set<MotCle> getMotscle() {
		return motscle;
	}

	public void setMotscle(Set<MotCle> motscle) {
		this.motscle = motscle;
	}

	
}
