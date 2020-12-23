package org.sid.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
	@Id @GeneratedValue
    private Long idRole;
    private String nomRole;
    
	public Role(Long id, String nomRole) {
		super();
		this.idRole = id;
		this.nomRole = nomRole;
	}
	public Role(String nomRole) {
		super();
		this.nomRole = nomRole;
	}
	public Long getId() {
		return idRole;
	}
	public void setId(Long id) {
		this.idRole = id;
	}
	public String getNomRole() {
		return nomRole;
	}
	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}
    
    
}
