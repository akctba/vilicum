package br.org.vilicum.view;

import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.FamiliaBC;
import br.org.vilicum.business.MembroBC;
import br.org.vilicum.correios.BuscaCEP;
import br.org.vilicum.domain.Estados;
import br.org.vilicum.domain.Familia;
import br.org.vilicum.domain.Membro;

@ViewController
@PreviousView("./familia_list.jsf")
public class FamiliaEditMB extends AbstractEditPageBean<Familia, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private FamiliaBC familiaBC;

	@Inject
	private MembroBC membroBC;

	@Inject
	private MessageContext messageContext;

	@Override
	@Transactional
	public String delete() {
		this.familiaBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.familiaBC.insert(getBean());
		return ""; // vazio para manter na mesma pagina getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.familiaBC.update(getBean());
		return ""; // getPreviousView();
	}

	@Override
	protected Familia handleLoad(Long id) {
		return this.familiaBC.load(id);
	}

	public void buscaCep() {

		Familia fam = this.getBean();

		String cep = fam.getCep();

		if (cep != null && cep.length() == 9) { // considerando o hifen

			try {
				BuscaCEP buscaCep = new BuscaCEP(cep);
				buscaCep.buscarEndereco();
				
				if(buscaCep.isFound()) {
					fam.setRua(buscaCep.getEndereco());
					fam.setBairro(buscaCep.getBairro());
					fam.setCidade(buscaCep.getCidade());
					Estados estado = Estados.parseEstado(buscaCep.getUf());
					fam.setEstado(estado);
				} else {
					//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CEP não encontrado: " + cep, null));
					messageContext.add("CEP não encontrado: " + cep, SeverityType.INFO);
					fam.setRua("CEP não encontrado");
				}

			} catch (Exception e) {
				messageContext.add("Erro ao buscar CEP: " + cep, SeverityType.INFO);
				System.out.println("SigepClienteException " + e.getMessage());
				e.printStackTrace();
				fam.setRua("Erro ao buscar CEP");
			}
		}
	}

	public Estados[] getEstados() {
		return Estados.values();
	}

	public List<Membro> ativos() {
		return membroBC.ativos(getBean());
	}
}