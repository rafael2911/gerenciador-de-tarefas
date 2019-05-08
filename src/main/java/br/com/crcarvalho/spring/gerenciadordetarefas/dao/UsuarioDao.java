package br.com.crcarvalho.spring.gerenciadordetarefas.dao;

import java.util.List;

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
	
	public List<Object> findAll(){
		return manager.createQuery("from Usuario u", Object.class)
				.getResultList();
	}

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
	
	public Usuario save(Usuario usuario) {
		
		manager.persist(usuario);
		
		return usuario;
		
	}

}
