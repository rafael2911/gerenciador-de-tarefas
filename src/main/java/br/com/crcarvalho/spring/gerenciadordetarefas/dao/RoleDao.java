package br.com.crcarvalho.spring.gerenciadordetarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.crcarvalho.spring.gerenciadordetarefas.model.Role;

@Repository
public class RoleDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Role> findAll(){
		return manager.createQuery("from Role r", Role.class).getResultList();
	}
	
	public Role save(Role role) {
		manager.persist(role);
		return role;
	}
	
}
