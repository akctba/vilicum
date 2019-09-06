package br.org.vilicum.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.vilicum.domain.Pastor;
import br.org.vilicum.util.CustomDate;

@PersistenceController
public class PastorDAO extends JPACrud<Pastor, Long> {

	private static final long serialVersionUID = 3844191198150210400L;
	
	@Inject
	private EntityManager em;
	
	public List<Pastor> findByCongregacao(long id) {
		String q = "SELECT a ";
		q += "FROM Pastor a, CongregacaoPastor b ";
		q += "WHERE a.idPastor = b.pastor.idPastor ";
		q += "and (a.exclusao is null or a.exclusao < :sysdate) ";
		q += "and b.entrada < :sysdate ";
		q += "and (b.saida is null or b.saida < :sysdate) ";
		q += "AND b.congregacao.idCon = :con ";
		
		TypedQuery<Pastor> tq = em.createQuery(q, Pastor.class);
		tq.setParameter("sysdate", CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		tq.setParameter("con", id);
		
		return tq.getResultList();
	}
	

}
