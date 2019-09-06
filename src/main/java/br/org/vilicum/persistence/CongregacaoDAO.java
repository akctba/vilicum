package br.org.vilicum.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.util.CustomDate;

@PersistenceController
public class CongregacaoDAO extends JPACrud<Congregacao, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5280911697959046436L;
	
	@Inject
	private EntityManager em;

	public Congregacao findById(Long id) {
		String q = "select a from Congregacao a where a.idCon = ?1 ";
		TypedQuery<Congregacao> tq = em.createQuery(q, Congregacao.class);
		tq.setParameter(1, CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		return tq.getSingleResult();
	}

	public List<Congregacao> ativas() {
		String q = "select a from Congregacao a where a.exclusao is null or a.exclusao > ?1 ";
		TypedQuery<Congregacao> tq = em.createQuery(q, Congregacao.class);
		tq.setParameter(1, CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		return tq.getResultList();
	}
}
