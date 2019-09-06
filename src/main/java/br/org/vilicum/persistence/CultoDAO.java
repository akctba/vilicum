package br.org.vilicum.persistence;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Culto;

@PersistenceController
public class CultoDAO extends JPACrud<Culto, Long> {

	private static final long serialVersionUID = 6190125730439749807L;
	
	@Inject
	private EntityManager em;
	
	public List<Culto> findAll(Congregacao c) {
		String q = "select a from Culto a where a.congregacao.idCon = :idCon order by a.data desc ";
		TypedQuery<Culto> tq = em.createQuery(q, Culto.class);
		tq = tq.setParameter("idCon", c.getIdCon());
		return tq.getResultList();
	}
	
	@Override
	public Culto insert(Culto entity) {
		Culto insert = super.insert(entity);
		em.flush();
		return insert;
	}

	@Override
	public Culto update(Culto entity) {
		Culto update = super.update(entity);
		//em.flush();
		return update;
	}

	
	public Long cultosAno(int ano, Congregacao c) {
		Long qtd = 0L;
		
		String sql = "select count(*) as qtd from CULTO c where c.idcon=? and YEAR(c.data) = ? "; 
		Query query = em.createNativeQuery(sql);
		
		query.setParameter(1, c.getId());
		query.setParameter(2, ano);
		
		qtd = (Long) query.getSingleResult();
		
		return qtd;
	}
	
	public List frequencia(int ano, Congregacao c) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select extract(month from c.data) as mes, sum(c.adultos+c.criancas) as part ");
		sql.append(" from CULTO c ");
		sql.append(" where idcon = ? ");
		sql.append(" and extract(year from c.data) = ? ");
		sql.append(" group by extract(month from c.data) ");
		sql.append(" order by 1 ");
		
		Query query = em.createNativeQuery(sql.toString());
		
		query.setParameter(1, c.getId());
		query.setParameter(2, ano);
		
		return query.getResultList();
		
	}

	public boolean exists(Culto bean) {
		String sql = "select count(*) as qtd from CULTO c where c.idcon=? and c.data=? "; 
		Query query = em.createNativeQuery(sql);
		
		query.setParameter(1, bean.getCongregacao().getId());
		query.setParameter(2, bean.getData());
		
		long qtd = (Long) query.getSingleResult();
		
		return (qtd>0);
	}

	public Long visitantesAno(long ano, Congregacao c) {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select sum(c.VISITANTES) as total ");
		sql.append(" from CULTO c ");
		sql.append(" where idcon = ? ");
		sql.append(" and extract(year from c.data) = ? ");
		
		Query query = em.createNativeQuery(sql.toString());
		
		query.setParameter(1, c.getId());
		query.setParameter(2, ano);
		
		BigDecimal result = (BigDecimal) query.getSingleResult();
		return (result!=null?result.longValue():0L);
	}
	
	public List participacao(Congregacao c, Date dtIni, Date dtFim) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select a.qtd, count(1) as x ");
		sql.append(" from (select p.idmembro, count(1) as qtd ");
		sql.append(" from santaceia p ");
		sql.append(" join CULTO c on c.IDCULTO = p.idCulto ");
		sql.append(" where c.idCon = ? ");
		sql.append(" and c.data between ? and ? ");
		sql.append(" group by p.idmembro ");

		sql.append(" union ");

		sql.append(" select m.IDMEMBRO, 0 as qtd ");
		sql.append(" from MEMBRO m ");
		sql.append(" where m.DATASAIDA is null ");
		sql.append(" and m.idCon = ? ");
		sql.append(" and not exists (select 1 from santaceia s ");
		sql.append("                   join CULTO c on c.IDCULTO = s.IDCULTO ");
		sql.append(" 				 where s.idMembro = m.idmembro ");
		sql.append("                    and c.DATA between ? and ?) ");
		sql.append(" group by m.IDMEMBRO ");

		sql.append(" ) a ");
		sql.append(" group by a.qtd ");
		sql.append(" order by 1 ");
		
		Query query = em.createNativeQuery(sql.toString());
		
		int i = 1;
		query.setParameter(i++, c.getId());
		query.setParameter(i++, dtIni);
		query.setParameter(i++, dtFim);
		query.setParameter(i++, c.getId());
		query.setParameter(i++, dtIni);
		query.setParameter(i++, dtFim);
		
		return query.getResultList();
		
	}

}
