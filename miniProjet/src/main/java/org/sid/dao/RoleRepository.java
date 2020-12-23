package org.sid.dao;

import org.sid.beans.Article;
import org.sid.beans.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

	public Role getRoleByNomRole(String roleName);
}
