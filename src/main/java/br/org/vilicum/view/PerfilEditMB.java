package br.org.vilicum.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.PerfilBC;
import br.org.vilicum.domain.Perfil;

@ViewController
@PreviousView("./perfil_list.jsf")
public class PerfilEditMB extends AbstractEditPageBean<Perfil, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PerfilBC perfilBC;
	
	@Override
	@Transactional
	@RequiredRole("Administrador")
	public String delete() {
		this.perfilBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	@RequiredRole("Administrador")
	public String insert() {
		this.perfilBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	@RequiredRole("Administrador")
	public String update() {
		this.perfilBC.update(getBean());
		return getPreviousView();
	}
	
	protected void handleLoad() {
		setBean(this.perfilBC.load(getId()));
	}

	@Override
	protected Perfil handleLoad(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}