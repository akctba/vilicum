package br.org.vilicum.persistence;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Membro;
import br.org.vilicum.domain.view.UltimaParticipacao;

@PersistenceController
public class UltimaParticipacaoDAO extends JPACrud<UltimaParticipacao, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5821350270328054089L;
	
	@Inject
	private EntityManager em;
	
	public List<UltimaParticipacao> findAll(Congregacao c) {
		String q = "select a from UltimaParticipacao a where a.idCon = :idCon order by a.ultima ";
		TypedQuery<UltimaParticipacao> tq = em.createQuery(q, UltimaParticipacao.class);
		tq.setParameter("idCon", c.getIdCon());
		List<UltimaParticipacao> resultList = tq.getResultList();
		return resultList;
	}

	public Date ultimaParticipacao(Membro m) {
		String q = "select a from UltimaParticipacao a where a.idCon = :idCon and a.idMembro = :idMem ";
		TypedQuery<UltimaParticipacao> tq = em.createQuery(q, UltimaParticipacao.class);
		tq.setParameter("idCon", m.getCongregacao().getIdCon());
		tq.setParameter("idMem", m.getIdMembro());
		
		UltimaParticipacao sr = null;
		
		List<UltimaParticipacao> resultList = tq.getResultList();
		if (resultList != null && resultList.size() > 0) {
			sr = resultList.get(0);
		}
		
		return (sr!=null?sr.getUltima():null);
	}

}
