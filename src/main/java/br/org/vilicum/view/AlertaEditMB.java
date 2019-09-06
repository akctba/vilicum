
package br.org.vilicum.view;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.AlertaBC;
import br.org.vilicum.business.CongregacaoBC;
import br.org.vilicum.business.UsuarioBC;
import br.org.vilicum.domain.Alerta;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Usuario;


@ViewController
@PreviousView("./alerta_list.jsf")
public class AlertaEditMB extends AbstractEditPageBean<Alerta, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AlertaBC alertaBC;
	

	@Inject
	private UsuarioBC usuarioBC;
	
	public List<Usuario> getUsuarioList(){
		return usuarioBC.findAll();
	}
			
	@Inject
	private CongregacaoBC congregacaoBC;
	
	public List<Congregacao> getCongregacaoList(){
		return congregacaoBC.findAll();
	}
			
	
	@Override
	@Transactional
	public String delete() {
		this.alertaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.alertaBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.alertaBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Alerta handleLoad(Long id) {
		return this.alertaBC.load(id);
	}
	
}