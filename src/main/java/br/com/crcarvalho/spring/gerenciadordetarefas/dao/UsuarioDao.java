package br.com.crcarvalho.spring.gerenciadordetarefas.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.crcarvalho.spring.gerenciadordetarefas.model.Usuario;

@Repository
public class UsuarioDao implements UserDetailsService {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = null;
		
		try {
			usuario = manager.createQuery("from Usuario u where u.email = :email", Usuario.class)
					.setParameter("email", email)
					.getSingleResult();
		}catch (NoResultException ex) {
		 throw new UsernameNotFoundException("O usuario " + email + " não foi encontrado.");
		}
		
		return usuario;
	}

}