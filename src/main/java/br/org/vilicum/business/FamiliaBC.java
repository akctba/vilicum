package br.org.vilicum.business;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Familia;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.persistence.FamiliaDAO;

@BusinessController
public class FamiliaBC extends DelegateCrud<Familia, Long, FamiliaDAO> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8853064545161938118L;

	@Inject
	private FamiliaDAO dao;
	
	@Inject
	private SecurityContext securityContext;
	
	public Familia findById(Long id) {
		return dao.load(id);
	}
	
	public List<Familia> ativas() {
		
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		return dao.ativas(c);
	}

	public List<Familia> findAll(Congregacao c) {
		return dao.ativas(c);
	}

	@Override
	public Familia insert(Familia bean) {
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
	public Familia update(Familia bean) {
		if (bean != null) {
			if (bean.getCongregacao() == null) {
				Usuario user = (Usuario) securityContext.getUser();
				Congregacao c = user.getCongregacao();
				bean.setCongregacao(c);
			}
		}
		return super.update(bean);
	}	
}
