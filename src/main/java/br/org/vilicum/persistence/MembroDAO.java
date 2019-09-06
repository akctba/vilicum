package br.org.vilicum.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Culto;
import br.org.vilicum.domain.Familia;
import br.org.vilicum.domain.Membro;
import br.org.vilicum.pojo.Movimento;
import br.org.vilicum.util.CustomDate;

@PersistenceController
public class MembroDAO extends JPACrud<Membro, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 74543901340614152L;
	
	@Inject
	private EntityManager em;
	
	public List<Membro> ativos(Congregacao c) {
		String q = "select a from Membro a where (a.dataSaida is null or a.dataSaida > :dt) and a.congregacao.idCon = :idCon and a.excluir = false ";
		TypedQuery<Membro> tq = em.createQuery(q, Membro.class);
		tq.setParameter("dt", CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		tq.setParameter("idCon", c.getIdCon());
		return tq.getResultList();
	}
	
	public List<Membro> ativosComungantes(Congregacao c) {
		return ativosComungantes(c, true);
	}
	
	public List<Membro> ativosComungantes(Congregacao c, boolean comungantes) {
		String q = "select a from Membro a where (a.dataSaida is null or a.dataSaida > :dt) and a.comungante = :com and a.congregacao.idCon = :idCon and a.excluir = false ";
		TypedQuery<Membro> tq = em.createQuery(q, Membro.class);
		tq.setParameter("dt", CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		tq.setParameter("com", comungantes);
		tq.setParameter("idCon", c.getIdCon());
		return tq.getResultList();
	}
	
	public List<Membro> findAll(Congregacao c) {
		String q = "select a from Membro a where a.congregacao.idCon = :idCon";
		TypedQuery<Membro> tq = em.createQuery(q, Membro.class);
		tq.setParameter("idCon", c.getIdCon());
		return tq.getResultList();
	}

	public List<Membro> ativos(Familia f) {
		String q = "select a from Membro a where a.familia.idFam = :idFam and (a.dataSaida is null or a.dataSaida > :dt) and a.excluir = false ";
		TypedQuery<Membro> tq = em.createQuery(q, Membro.class);
		tq.setParameter("idFam", f.getId());
		tq.setParameter("dt", CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		return tq.getResultList();
	}

	public List<Membro> naoParticiparam(Congregacao c, Culto culto) {
		String q = "select a from Membro a where (a.dataSaida is null or a.dataSaida > :dt) ";
		q += "and a.comungante = :com and a.congregacao.idCon = :idCon and a.excluir = false ";
		q += "and not exists (select p from Participacao p where p.culto.idCulto= :idCulto and p.membro.idMembro=a.idMembro) ";
		TypedQuery<Membro> tq = em.createQuery(q, Membro.class);
		tq.setParameter("dt", CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		tq.setParameter("com", true);
		tq.setParameter("idCon", c.getIdCon());
		tq.setParameter("idCulto", culto.getIdCulto());
		return tq.getResultList();
	}

	public long qtdAtivosComungantes(Congregacao c, boolean comungantes) {
		return ativosComungantes(c, comungantes).size();
	}
	
	public List<Membro> ativosComungantes(Congregacao c, Date dt, boolean b) {
		String q = "select a from Membro a where a.comungante = :com ";
		q += "and a.congregacao.idCon = :idCon and a.dataEntrada <= :dt ";
		q += "and (a.dataSaida is null or a.dataSaida >= :dt) and a.excluir = false ";
		TypedQuery<Membro> tq = em.createQuery(q, Membro.class);
		tq.setParameter("com", b);
		tq.setParameter("idCon", c.getIdCon());
		tq.setParameter("dt", CustomDate.getCalendar(null), TemporalType.TIMESTAMP);
		return tq.getResultList();
	}
	
	public Long qtdAtivosPorAno(Congregacao c, long ano, boolean comungante) {
		
		Long qtd = 0L;
				
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(1) as qtd ");
		sql.append(" from MEMBRO m  ");
		sql.append(" where m.idCon = ? ");
		sql.append(" and m.comungante = ? ");
		sql.append(" and ((? >= m.DATAENTRADA and m.DATASAIDA is null) or ");
		sql.append(" (? between m.DATAENTRADA and m.DATASAIDA)) ");
		 
		Query query = em.createNativeQuery(sql.toString());
		
		query.setParameter(1, c.getId());
		query.setParameter(2, comungante);
		Date dtAno = CustomDate.parseDate("31/12/"+ano);
		query.setParameter(3, dtAno);
		query.setParameter(4, dtAno);
		
		qtd = (Long) query.getSingleResult();
		
		return qtd;
	}

	public BigDecimal percCadastro(Congregacao c) {
		
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT avg( ");
		sql.append(" ((CASE WHEN m.ESTADOCIVIL is null THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN m.SEXO is null THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN m.NASCIMENTO is null THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN m.DATAENTRADA is null THEN 0 ELSE 2 END) + ");
		sql.append(" (CASE WHEN m.COMUNGANTEDESDE is null THEN 0 ELSE 2 END) + ");
		sql.append(" (CASE WHEN LENGTH(TRIM(m.EMAIL)) < 3 THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN m.RECADASTRO is null THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN (TO_DAYS(CURDATE())-TO_DAYS(RECADASTRO)) > 365 THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN m.NOME is null THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN LENGTH(TRIM(m.CELULAR)) < 8 THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN LENGTH(TRIM(m.PROFISSAO)) < 5 THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN LENGTH(TRIM(f.fonefixo)) < 8 THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN f.bairro is null THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN f.cidade is null THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN f.cep is null THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN f.estado is null THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN f.nro is null THEN 0 ELSE 1 END) + ");
		sql.append(" (CASE WHEN f.rua is null THEN 0 ELSE 1 END) ");
		sql.append("    ) /20 ) * 100 media ");
		sql.append(" FROM MEMBRO m, FAMILIA f ");
		sql.append(" WHERE m.idfam = f.idfam ");
		sql.append(" and m.idCon = ? ");
		sql.append(" and m.datasaida is null ");
 
		Query query = em.createNativeQuery(sql.toString());
		
		query.setParameter(1, c.getId());
		
		return (BigDecimal) query.getSingleResult();
	}

	public BigDecimal validadeCadastro(Congregacao c) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT avg((CASE WHEN ((TO_DAYS(CURDATE())-TO_DAYS(IFNULL(RECADASTRO, '1900-01-01' ))) > 365) ");
		sql.append(" THEN 0 ELSE 1 END) ) * 100 media ");
		sql.append(" FROM MEMBRO m ");
		sql.append(" WHERE m.idCon = ? ");
		sql.append(" and m.datasaida is null ");
 
		Query query = em.createNativeQuery(sql.toString());
		
		query.setParameter(1, c.getId());
		
		return (BigDecimal) query.getSingleResult();
	}

	public List<Movimento> entradasMes(Congregacao c, Calendar i, Calendar f) {
		List<Movimento> lista = new ArrayList<Movimento>();
		
		String q = "select a from Membro a where a.congregacao.idCon = :idCon and a.dataEntrada between :dti and :dtf and a.excluir = false ";
		TypedQuery<Membro> tq = em.createQuery(q, Membro.class);
		tq.setParameter("idCon", c.getIdCon());
//		tq.setParameter("dti", CustomDate.getFirstDay(month), TemporalType.TIMESTAMP);
//		tq.setParameter("dtf", CustomDate.getLastDay(month), TemporalType.TIMESTAMP);
		tq.setParameter("dti", i, TemporalType.TIMESTAMP);
		tq.setParameter("dtf", f, TemporalType.TIMESTAMP);
		
		List<Membro> resultList = tq.getResultList();
		
		if (resultList != null) {
			for (Membro m : resultList) {
				Movimento mov = new Movimento();
				mov.setIdMem(m.getId());
				mov.setMembro(m.getNome());
				mov.setMotivo(m.getFormaIngresso().getForma());
				mov.setDatamov(m.getDataEntrada());
				lista.add(mov);
			}
		}
		
		return lista;
	}

	public List<Movimento> saidasMes(Congregacao c, Calendar i, Calendar f) {
		List<Movimento> lista = new ArrayList<Movimento>();
		
		String q = "select a from Membro a where a.congregacao.idCon = :idCon and a.dataSaida between :dti and :dtf and a.excluir = false ";
		TypedQuery<Membro> tq = em.createQuery(q, Membro.class);
		tq.setParameter("idCon", c.getIdCon());
		tq.setParameter("dti", i, TemporalType.TIMESTAMP);
		tq.setParameter("dtf", f, TemporalType.TIMESTAMP);
		
		List<Membro> resultList = tq.getResultList();
		
		if (resultList != null) {
			for (Membro m : resultList) {
				Movimento mov = new Movimento();
				mov.setIdMem(m.getId());
				mov.setMembro(m.getNome());
				mov.setMotivo(m.getMotivoInativo());
				mov.setDatamov(m.getDataSaida());
				lista.add(mov);
			}
		}
		
		return lista;
	}

	public List<Movimento> analise(Congregacao c) {
		List<Movimento> lista = new ArrayList<Movimento>();
		
		StringBuffer q = new StringBuffer();
		
		q.append("select m.idmembro, m.nome, m.analise from analisecadastro m WHERE m.idCon=? ");
		
		Query query = em.createNativeQuery(q.toString());
		int p = 1;
		query.setParameter(p++, c.getIdCon());
		
		List resultList = query.getResultList();
		
		if (resultList != null) {
			for (int i=0; i<resultList.size(); i++) {
				Object o[] = (Object[])resultList.get(i);
				Movimento mov = new Movimento();
				mov.setIdMem(o[0]!=null?((Long)o[0]):0L);
				mov.setMembro(o[1]!=null?o[1].toString():"nome");
				mov.setMotivo(o[2]!=null?o[2].toString():"erro");
				lista.add(mov);
			}
		}
		
		return lista;
	}

	public List<Membro> criancas(Congregacao c) {
		
		String q = "select a from Membro a where a.congregacao.idCon = :idCon and a.dataSaida is null and a.comungante = false and a.excluir = false ";
		TypedQuery<Membro> tq = em.createQuery(q, Membro.class);
		tq.setParameter("idCon", c.getIdCon());
		
		List<Membro> resultList = tq.getResultList();
		
		Collections.sort(resultList);
		
		return resultList;
	}

	public List<Membro> ofertantes(Congregacao c) {
		String q = "select a from Membro a where a.congregacao.idCon = :idCon and a.dataSaida is null and a.comungante = true and a.excluir = false ";
		TypedQuery<Membro> tq = em.createQuery(q, Membro.class);
		tq.setParameter("idCon", c.getIdCon());
		
		List<Membro> resultList = tq.getResultList();
		
		Collections.sort(resultList);
		
		return resultList;
	}


}
