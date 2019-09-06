package br.org.vilicum.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.vilicum.domain.Ingresso;
import br.org.vilicum.util.CustomDate;

@PersistenceController
public class IngressoDAO extends JPACrud<Ingresso, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4141769634428888147L;
	
	@Inject
	private EntityManager em;

	public List<Ingresso> ativos() {
		String q = "select a from Ingresso a where a.exclusao is null or a.exclusao > ?1 ";
		TypedQuery<Ingresso> tq = em.createQuery(q, Ingresso.class);
		tq.setParameter(1, CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		return tq.getResultList();
	}

}
