
package br.org.vilicum.view;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.MembroBC;
import br.org.vilicum.business.PastorBC;
import br.org.vilicum.business.RegistroPastoralBC;
import br.org.vilicum.domain.Membro;
import br.org.vilicum.domain.Pastor;
import br.org.vilicum.domain.RegistroPastoral;

// To remove unused imports press: Ctrl+Shift+o

@ViewController
@PreviousView("./registroPastoral_list.jsf")
public class RegistroPastoralEditMB extends AbstractEditPageBean<RegistroPastoral, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private RegistroPastoralBC registroPastoralBC;
	

	@Inject
	private MembroBC membroBC;
	
	public List<Membro> getMembroList(){
		return membroBC.findAll();
	}
			
	@Inject
	private PastorBC pastorBC;
	
	public List<Pastor> getPastorList(){
		return pastorBC.findAll();
	}
			
	
	@Override
	@Transactional
	public String delete() {
		this.registroPastoralBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.registroPastoralBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.registroPastoralBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected RegistroPastoral handleLoad(Long id) {
		return this.registroPastoralBC.load(id);
	}	
}