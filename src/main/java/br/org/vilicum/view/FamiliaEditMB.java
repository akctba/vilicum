package br.org.vilicum.view;

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
				Unirest.setTimeouts(0, 0);
				HttpResponse<String> response = Unirest
						.post("https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl")
						.header("Content-Type", "application/xml")
						.body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" \n\txmlns:cli=\"http://cliente.bean.master.sigep.bsb.correios.com.br/\">\n <soapenv:Header/>\n <soapenv:Body>\n <cli:consultaCEP>\n <cep>81710310</cep>\n </cli:consultaCEP>\n </soapenv:Body>\n</soapenv:Envelope> ")
						.asString();

				


//				
//				if (endereco != null) {
//					fam.setRua(endereco.getEnd());
//					fam.setBairro(endereco.getBairro());
//					fam.setCidade(endereco.getCidade());
//									
//					Estados estado = Estados.parseEstado(endereco.getUf());
//					
//					fam.setEstado(estado);
//					
//				} else {
//					//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "CEP não encontrado: " + cep, null));
//					messageContext.add("CEP não encontrado: " + cep, SeverityType.INFO);
//					fam.setRua("CEP não encontrado");
//				}
//			} catch (SQLException_Exception e) {
//				messageContext.add("Erro ao buscar CEP: " + cep, SeverityType.INFO);
//				System.out.println("SQLException_Exception " + e.getMessage());
////				e.printStackTrace();
//				fam.setRua("Erro ao buscar CEP");
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