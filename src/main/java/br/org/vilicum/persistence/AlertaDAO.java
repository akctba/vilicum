package br.org.vilicum.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.vilicum.domain.Alerta;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.util.CustomDate;

@PersistenceController
public class AlertaDAO extends JPACrud<Alerta, Long> {

	private static final long serialVersionUID = 204004047930578883L;
	
	@Inject
	private EntityManager em;
	
	public List<Alerta> ativos(Congregacao c) {
		String q = "select a from Alerta a "
				+ "where a.cadastro <= :dtIni "
				+ "and (a.validade is null or a.validade > :dtValidade) "
				+ "and a.congregacao.idCon = :idCon "
				+ "and a.execucao is null ";
		TypedQuery<Alerta> tq = em.createQuery(q, Alerta.class);
		tq.setParameter("dtIni", CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		tq.setParameter("dtValidade", CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		tq.setParameter("idCon", c.getIdCon());
		return tq.getResultList();
	}

}
