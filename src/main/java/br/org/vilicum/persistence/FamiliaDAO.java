package br.org.vilicum.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Familia;
import br.org.vilicum.util.CustomDate;

@PersistenceController
public class FamiliaDAO extends JPACrud<Familia, Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2488340724909059171L;
	
	@Inject
	private EntityManager em;
	
	public List<Familia> ativas(Congregacao c) {
		String q = "select a from Familia a where a.congregacao.idCon = :idCon and (a.exclusao is null or a.exclusao > :dt) ";
		TypedQuery<Familia> tq = em.createQuery(q, Familia.class);
		tq.setParameter("dt", CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		tq.setParameter("idCon", c.getIdCon());
		return tq.getResultList();
	}
	
	public List<Familia> findAll(Congregacao c) {
		String q = "select a from Familia a where a.congregacao.idCon = :idCon ";
		TypedQuery<Familia> tq = em.createQuery(q, Familia.class);
		tq = tq.setParameter("idCon", c.getIdCon());
		return tq.getResultList();
	}

}
