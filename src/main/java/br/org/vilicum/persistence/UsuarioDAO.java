package br.org.vilicum.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.util.CustomDate;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1533908426610704861L;
	
	@Inject
	private EntityManager em;
	
	public List<Usuario> findAtivos() {
		String q = "select a from Usuario a where a.exclusao is null or a.exclusao > :dt ";
		TypedQuery<Usuario> tq = em.createQuery(q, Usuario.class);
		tq.setParameter("dt", CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		return tq.getResultList();
	}

	public List<Usuario> findByEmail(String email) {
		String q = "select a from Usuario a where a.email = :em and a.exclusao is null or a.exclusao > :dt ";
		TypedQuery<Usuario> tq = em.createQuery(q, Usuario.class);
		tq.setParameter("em", email);
		tq.setParameter("dt", CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		return tq.getResultList();
	}

	/**
	 * Busca por ID e email
	 * @return Usuario
	 */
	public Usuario findByIdEmail(String id, String email) {
		try {
			String q = "select a from Usuario a where a.email = :em and a.id = :login ";
			TypedQuery<Usuario> tq = em.createQuery(q, Usuario.class);
			tq.setParameter("em", email);
			tq.setParameter("login", id);
			Usuario singleResult = tq.getSingleResult();
			return singleResult;
		} catch (javax.persistence.NoResultException nre) {
			// usuario não encontrado
		} catch (Exception e) {
			// erro não esperado
		}
		return null;
	}

}
