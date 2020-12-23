package org.sid.dao;


import java.util.List;

import org.sid.beans.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

	//visualiser les jury
	@Query("SELECT u from Utilisateur u where u.role.nomRole='jury'")
	public List<Utilisateur> getJury(); 
	
	public Utilisateur getUserByUsername(String username);
}
