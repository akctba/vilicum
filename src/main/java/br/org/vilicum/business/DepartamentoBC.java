package br.org.vilicum.business;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Departamento;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.persistence.DepartamentoDAO;

@BusinessController
public class DepartamentoBC extends DelegateCrud<Departamento, Long, DepartamentoDAO> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4253688790428738168L;

	@Inject
	private DepartamentoDAO dao;

	@Inject
	private SecurityContext securityContext;
	
	public Departamento findById(Long id) {
		return dao.load(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		//super.delete(id);
	}

	@Override
	public void delete(List<Long> ids) {
		// TODO Auto-generated method stub
		//super.delete(ids);
	}

	@Override
	public Departamento insert(Departamento bean) {
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
	public Departamento update(Departamento bean) {
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
