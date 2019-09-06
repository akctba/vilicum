
package br.org.vilicum.business;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.domain.Alerta;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.persistence.AlertaDAO;
import br.org.vilicum.util.CustomDate;

@BusinessController
public class AlertaBC extends DelegateCrud<Alerta, Long, AlertaDAO> {
	
	private static final long serialVersionUID = -310783765837855766L;

	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private CongregacaoBC congBC;
	
	@Inject
	private AlertaDAO dao;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			for(Congregacao c : congBC.ativas()) {
				Alerta alerta = new Alerta("Bem vindo! Já conhece o sistema?",
						CustomDate.getCurrentDate(), null, c,
						null, null);
				
				insert(alerta);
			}
		}
	}

	@Override
	public Alerta insert(Alerta bean) {
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
	public Alerta update(Alerta bean) {
		if (bean != null) {
			if (bean.getCongregacao() == null) {
				Usuario user = (Usuario) securityContext.getUser();
				Congregacao c = user.getCongregacao();
				bean.setCongregacao(c);
			}
		}
		return super.update(bean);
	}

	@Override
	public void delete(Long id) {
		// exclusao fisica nao permitida
		//super.delete(id);
	}

	@Override
	public void delete(List<Long> ids) {
		// exclusao fisica nao permitida
		//super.delete(ids);
	}
	
	public List<Alerta> findAtivos() {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		return dao.ativos(c);
	}
	
}
