package br.org.vilicum.business;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.LoggedIn;
import br.gov.frameworkdemoiselle.security.RequiredPermission;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.vilicum.constant.Constantes;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Culto;
import br.org.vilicum.domain.Familia;
import br.org.vilicum.domain.Membro;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.persistence.MembroDAO;
import br.org.vilicum.pojo.Movimento;

@BusinessController
public class MembroBC extends DelegateCrud<Membro, Long, MembroDAO> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2416626843556252114L;
	
	@Inject
	private SecurityContext securityContext;
	
	@Inject 
	private MembroDAO dao;
	
	public Membro findById(Long id) {
		return dao.load(id);
	}

	@Override
	@RequiredPermission(resource="membro", operation="delete")
	public void delete(Long id) {
		//super.delete(id);
		//nao permitir exclusao fisica
	}

	@Override
	@RequiredPermission(resource="membro", operation="delete")
	public void delete(List<Long> ids) {
		//super.delete(ids);
		//nao permitir exclusao fisica
	}
	
	public List<Membro> findAll(Congregacao c) {
		return dao.ativos(c);
	}
	
	@Override
	@LoggedIn
	public List<Membro> findAll() {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		return dao.findAll(c);
	}

	@LoggedIn
	public List<Membro> findAtivos() {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		return dao.ativos(c);
	}

	@LoggedIn
	public List<Membro> findAtivosComungantes() {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		return dao.ativosComungantes(c);
	}
	
	public List<Membro> ativos(Familia f) {
		return dao.ativos(f);
	}
	
	@Override
	public Membro insert(Membro bean) {
		if (bean != null) {
			if (bean.getCongregacao() == null) {
				Usuario user = (Usuario) securityContext.getUser();
				Congregacao c = user.getCongregacao();
				bean.setCongregacao(c);
			}
		}
		return super.insert(bean);
	}

	@Override
	public Membro update(Membro bean) {
		if (bean != null) {
			if (bean.getCongregacao() == null) {
				Usuario user = (Usuario) securityContext.getUser();
				Congregacao c = user.getCongregacao();
				bean.setCongregacao(c);
			}
		}
		return super.update(bean);
	}

	public List<Membro> findNaoParticiparam(Culto culto) {
		if (culto == null) {
			return findAtivosComungantes();
		}
		
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		return dao.naoParticiparam(c, culto);
	}
	
	public Map<String, Number> qtdAtivosComungantes() {
		Map<String, Number> qtd = new HashMap<String, Number>();
		
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		qtd.put(Constantes.COMUNGANTES, dao.qtdAtivosComungantes(c, true));
		qtd.put(Constantes.NAO_COMUNGANTES, dao.qtdAtivosComungantes(c, false));
		
		return qtd;
	}
	
	public Map<String, Number> qtdAtivosComungantes(Date dt) {
		Map<String, Number> qtd = new HashMap<String, Number>();
		
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		qtd.put(Constantes.COMUNGANTES, dao.ativosComungantes(c, dt, true).size());
		qtd.put(Constantes.NAO_COMUNGANTES, dao.ativosComungantes(c, dt, false).size());
		
		return qtd;
	}
	
	public Long qtdAtivosComungantes(long ano, boolean comungante) {
		
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		Long qtd = dao.qtdAtivosPorAno(c, ano, comungante);
		
		return qtd;
	}

	public BigDecimal percCadastro() {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		return dao.percCadastro(c);
	}

	public BigDecimal validadeCadastro() {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		return dao.validadeCadastro(c);
	}

	public List<Movimento> entradasMes(Calendar i, Calendar f) {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		List<Movimento> entradasMes = dao.entradasMes(c, i, f);
		
		if (entradasMes != null) {
			Collections.sort(entradasMes);
		}
		
		return entradasMes;
	}

	public List<Movimento> saidasMes(Calendar i, Calendar f) {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		List<Movimento> saidasMes = dao.saidasMes(c, i, f);
		
		if (saidasMes != null) {
			Collections.sort(saidasMes);
		}
		
		return saidasMes;
	}

	public List<Movimento> analise() {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		return dao.analise(c);
	}

	public List<Membro> findCriancas() {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		return dao.criancas(c);
	}

	public List<Membro> findOfertantes() {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		return dao.ofertantes(c);
	}

}
