package br.org.vilicum.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.CultoBC;
import br.org.vilicum.business.MembroBC;
import br.org.vilicum.business.PastorBC;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Culto;
import br.org.vilicum.domain.Membro;
import br.org.vilicum.domain.Pastor;
import br.org.vilicum.domain.Usuario;

@ViewController
@PreviousView("./culto_lista.jsf")
@NextView("./culto_cadastro.jsf")
public class CultoEditMB extends AbstractEditPageBean<Culto, Long> {

	private static final long serialVersionUID = -2063272543740610355L;
	
	@Inject
    private Logger logger;

	@Inject
	private CultoBC cultoBC;
	
	@Inject 
	private PastorBC pastorBC;
	
	@Inject
	private MembroBC membroBC;
	
	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private MessageContext messageContext;
	
	private DualListModel<Membro> listadupla; //lista para usar o picklist Primefaces
	
	@Override
	@Transactional
	public String delete() {
		this.cultoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		try {
			Culto b = getBean();
			this.cultoBC.insert(b);
		} catch (Exception e) {
			messageContext.add("Erro ao gravar culto. ", SeverityType.ERROR, e.getMessage());
			e.printStackTrace();
		}
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.cultoBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected Culto handleLoad(Long id) {
		Culto load = this.cultoBC.load(id);
		return load;
	}
	
	public List<Pastor> getPastores() {
		
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		return pastorBC.pastoresCongregacao(c.getId());
	}
	
	public DualListModel<Membro> getListadupla() {
		if (listadupla == null) {
			
			List<Membro> source = membroBC.findAtivosComungantes();
			List<Membro> target = this.getBean().getSantaceia();
			if (target == null) {
				target = new ArrayList<Membro>();
			}
			
			// remover do source os membros que já estão selecionados 
			source.removeAll(target);
			
			// Ordena as listas
			Collections.sort(target);
			Collections.sort(source);
			
			listadupla = new DualListModel<Membro>(source, target);
		}
		return listadupla;
	}
	
	public void setListadupla(DualListModel<Membro> membros) {
		this.listadupla = membros;
	}
	
	public void onPickMember(TransferEvent event) {
	
		//this.getBean();
		//List<Membro> participacoes = culto.getSantaceia();
		try {
			if(event.isAdd()) {
				//salvar na base
				for(Object item : event.getItems()) {
					Membro m = (Membro) item;
					logger.debug("Inserindo na lista " + m);
					this.getBean().getSantaceia().add(m);
				}
				messageContext.add("Participação registrada. ", SeverityType.INFO);
			} else if(event.isRemove()) {
				//excluir da base
				for(Object item : event.getItems()) {
					Membro m = (Membro) item;
					logger.debug("Excluindo da lista " + m);
					for (Membro p : this.getBean().getSantaceia()) {
						if (p != null && m.getId() == p.getId()) {
							this.getBean().getSantaceia().remove(p);
							break;
						}
					}
				}
				messageContext.add("Participação retirada. ", SeverityType.INFO);
			}
			
			cultoBC.update(this.getBean());
		} catch (Exception e) {
			messageContext.add("Erro ao gravar participação. ", SeverityType.ERROR, e.getMessage());
		}
		
	}
	
}
